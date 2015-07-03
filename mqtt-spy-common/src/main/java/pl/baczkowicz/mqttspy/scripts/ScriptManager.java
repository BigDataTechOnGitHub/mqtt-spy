/***********************************************************************************
 * 
 * Copyright (c) 2014 Kamil Baczkowicz
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 *    Kamil Baczkowicz - initial API and implementation and/or initial documentation
 *    
 */
package pl.baczkowicz.mqttspy.scripts;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.baczkowicz.mqttspy.common.generated.ScriptDetails;
import pl.baczkowicz.mqttspy.connectivity.IMqttConnection;
import pl.baczkowicz.mqttspy.exceptions.CriticalException;
import pl.baczkowicz.mqttspy.messages.IBaseMessage;
import pl.baczkowicz.mqttspy.scripts.io.ScriptIO;
import pl.baczkowicz.mqttspy.utils.FileUtils;

/**
 * This class manages script creation and execution.
 */
public class ScriptManager
{
	/** Name of the variable in JS for received messages. */
	public static final String RECEIVED_MESSAGE_PARAMETER = "receivedMessage";
	
	/** Name of the variable in JS for published/searched message. */
	public static final String MESSAGE_PARAMETER = "message";
	
	public static final String SCRIPT_EXTENSION = ".js";
	
	/** Diagnostic logger. */
	private final static Logger logger = LoggerFactory.getLogger(ScriptManager.class);
	
	/** Mapping between unique script names and scripts. */
	private Map<String, Script> scripts = new HashMap<String, Script>();
	
	/** Used for notifying events related to script execution. */
	private IScriptEventManager eventManager;

	/** Executor for tasks. */
	private Executor executor;

	/** Connection for which the script will be run. */
	private IMqttConnection connection;
	
	/**
	 * Creates the script manager.
	 * 
	 * @param eventManager The event manager to be used
	 * @param executor The executor to be used
	 * @param connection The connection for which to run the scripts
	 */
	public ScriptManager(final IScriptEventManager eventManager, final Executor executor, final IMqttConnection connection)
	{
		this.eventManager = eventManager;
		this.executor = executor;
		this.setConnection(connection);
	}
	
	/**
	 * Gets the file (script) name for the given file object.
	 * 
	 * @param file The file from which to get the filename
	 * 
	 * @return The name of the script file
	 */
	public static String getScriptName(final File file)
	{
		return file.getName().replace(SCRIPT_EXTENSION,  "");
	}
	
	/**
	 * Creates and records a script with the given details.
	 * 
	 * @param scriptDetails The script details
	 * 
	 * @return Created script
	 */
	public Script addScript(final ScriptDetails scriptDetails)
	{
		final File scriptFile = new File(scriptDetails.getFile());
		
		final String scriptName = getScriptName(scriptFile);
		
		final Script script = new Script();
				
		createFileBasedScript(script, scriptName, scriptFile, getConnection(), scriptDetails);
		
		logger.info("Adding script {}", scriptDetails.getFile());
		scripts.put(scriptFile.getAbsolutePath(), script);
		
		return script;
	}
	
	/**
	 * Creates and records a script with the given details.
	 * 
	 * @param scriptName The script name
	 * @param content Script's content
	 * 
	 * @return Created script
	 */
	public Script addInlineScript(final String scriptName, final String content)
	{
		final Script script = new Script();
		script.setScriptContent(content);
		script.setScriptDetails(new ScriptDetails(true, false, null));
				
		createScript(script, scriptName, getConnection());
		
		logger.debug("Adding in-line script {}", scriptName);

		scripts.put(scriptName, script);
		
		return script;
	}
	
	/**
	 * Creates and records scripts with the given details.
	 * 
	 * @param scriptDetails The script details
	 */
	public List<Script> addScripts(final List<ScriptDetails> scriptDetails)
	{
		final List<Script> addedScripts = new ArrayList<>();
		
		for (final ScriptDetails script : scriptDetails)
		{
			addedScripts.add(addScript(script));			
		}
		
		return addedScripts;
	}
	
	/**
	 * Adds scripts from the given directory.
	 * 
	 * @param directory The directory to search for scripts
	 */
	public void addScripts(final String directory)
	{
		final List<File> files = new ArrayList<File>(); 
		
		if (directory != null && !directory.isEmpty())
		{
			files.addAll(FileUtils.getFileNamesForDirectory(directory, SCRIPT_EXTENSION));				
		}
		else
		{
			logger.error("Given directory is empty");
		}	
		
		populateScriptsFromFileList(files);
	}
	
	/**
	 * Populates scripts from a list of files. This doesn't override existing files.
	 * 
	 * @param files List of script files
	 * 
	 * @return The list of created (newly added) script objects
	 */
	public List<Script> populateScriptsFromFileList(final List<File> files)
	{
		final List<Script> addedScripts = new ArrayList<>();
		
		for (final File scriptFile : files)
		{
			Script script = scripts.get(Script.getScriptIdFromFile(scriptFile));
			
			if (script == null)					
			{
				final String scriptName = getScriptName(scriptFile);				
				script = new Script();
				
				createFileBasedScript(script, scriptName, scriptFile, getConnection(), new ScriptDetails(true, false, scriptFile.getName())); 			
				
				addedScripts.add(script);
				addScript(script);
			}				
		}
		
		return addedScripts;
	}
	
	/**
	 * Populates scripts from a list of script details.
	 * 
	 * @param scriptDetails List of script details
	 * 
	 * @return The list of created script objects
	 */
	public List<Script> populateScripts(final List<ScriptDetails> scriptDetails)
	{
		final List<Script> addedScripts = new ArrayList<>();
		
		for (final ScriptDetails details : scriptDetails)
		{
			final File scriptFile = new File(details.getFile());
			
			if (!scriptFile.exists())					
			{
				logger.warn("Script {} does not exist!", details.getFile());
			}
			else
			{
				logger.info("Adding script {}", details.getFile());
							
				Script script = scripts.get(Script.getScriptIdFromFile(scriptFile));
				
				if (script == null)					
				{
					final String scriptName = getScriptName(scriptFile);
					script = new Script();
					
					createFileBasedScript(script, scriptName, scriptFile, getConnection(), details); 			
					
					addedScripts.add(script);
					addScript(script);
				}	
			}
		}			
		
		return addedScripts;
	}
	
	/**
	 * Populates the script object with the necessary values and references.
	 * 
	 * @param script The script object to be populated
	 * @param scriptName The name of the script
	 * @param scriptFile The script's file name 
	 * @param connection The connection for which this script will be running
	 * @param scriptDetails Script details
	 */
	public void createFileBasedScript(final Script script,
			final String scriptName, final File scriptFile, final IMqttConnection connection, final ScriptDetails scriptDetails)
	{
		createScript(script, scriptName, connection);
		script.setScriptFile(scriptFile);
		script.setScriptDetails(scriptDetails);
	}
		
	/**
	 * Populates the script object with the necessary values and references.
	 * 
	 * @param script The script object to be populated
	 * @param scriptName The name of the script
	 * @param connection The connection for which this script will be running
	 */
	public void createScript(final Script script, final String scriptName, final IMqttConnection connection)
	{
		final ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");										
		
		if (scriptEngine != null)
		{
			script.setName(scriptName);			
			script.setStatus(ScriptRunningState.NOT_STARTED);
			script.setScriptEngine(scriptEngine);					
			script.setPublicationScriptIO(new ScriptIO(connection, eventManager, script, executor));
			
			final Map<String, Object> scriptVariables = new HashMap<String, Object>();
			scriptVariables.put("mqttspy", script.getPublicationScriptIO());	
			scriptVariables.put("logger", LoggerFactory.getLogger(ScriptRunner.class));
			scriptVariables.put("messageLog", script.getPublicationScriptIO().getMessageLog());
			
			putJavaVariablesIntoEngine(scriptEngine, scriptVariables);
		}
		else
		{
			throw new CriticalException("Cannot instantiate the nashorn javascript engine - most likely you don't have Java 8 installed. "
					+ "Please either disable scripts in your configuration file or install the appropriate JRE/JDK.");
		}
	}
				
	/**
	 * Puts a the given map of variables into the engine.
	 * 
	 * @param engine The engine to be populated with variables
	 * @param variables The variables to be populated
	 */
	public static void putJavaVariablesIntoEngine(final ScriptEngine engine, final Map<String, Object> variables)
	{		
		final Bindings bindings = new SimpleBindings();
		// final Bindings bindings = engine.createBindings();

		for (String key : variables.keySet())
		{
			bindings.put(key, variables.get(key));
		}

		engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
	}
	
	/**
	 * Runs the given script in a synchronous or asynchronous way.
	 * 
	 * @param script The script to run
	 * @param asynchronous Whether to run the script asynchronously or not
	 */
	public void runScript(final Script script, final boolean asynchronous)
	{
		// Only start if not running already
		if (!ScriptRunningState.RUNNING.equals(script.getStatus()))
		{
			script.createScriptRunner(eventManager, executor);
			script.setAsynchronous(asynchronous);
			
			if (asynchronous)
			{
				new Thread(script.getScriptRunner()).start();
			}
			else
			{
				script.getScriptRunner().run();
			}
		}
	}	
	
	/**
	 * Runs the given script and passes the given message as a parameter. Defaults to the 'receivedMessage' parameter and synchronous execution.
	 * 
	 * @param script The script to run
	 * @param message The message to be passed onto the script
	 */
	public void runScriptFileWithReceivedMessage(final String scriptFile, final IBaseMessage receivedMessage)
	{
		final Script script = getScriptObjectFromName(scriptFile);
		
		if (script != null)
		{
			runScriptFileWithMessage(script, ScriptManager.RECEIVED_MESSAGE_PARAMETER, receivedMessage, false);
		}
		else
		{
			logger.warn("No script file found at {}. Please check if this location is correct.", scriptFile);
		}
	}
	
	/**
	 * Runs the given script and passes the given message as a parameter. Defaults to the 'message' parameter and asynchronous execution.
	 * 
	 * @param script The script to run
	 * @param message The message to be passed onto the script
	 */
	public void runScriptFileWithMessage(final Script script, final IBaseMessage message)
	{				
		runScriptFileWithMessage(script, ScriptManager.MESSAGE_PARAMETER, message, true);
	}
	
	/**
	 * Runs the given script and passes the given message as a parameter.
	 * 
	 * @param script The script to run
	 * @param parameterName The name of the message parameter
	 * @param message The message to be passed onto the script
	 * @param asynchronous Whether the call should be asynchronous
	 */
	public void runScriptFileWithMessage(final Script script, final String parameterName, final IBaseMessage message, final boolean asynchronous)
	{				
		script.getScriptEngine().put(parameterName, message);
		runScript(script, asynchronous);		
	}
	
	public Object invokeFunction(final Script script, final String function, final Object... args) throws NoSuchMethodException, ScriptException
	{
		final Invocable invocable = (Invocable) script.getScriptEngine();
		
		return invocable.invokeFunction(function, args);
	}
	
	/**
	 * Gets script object for the given file.
	 * 
	 * @param scriptFile The file for which to get the script object
	 * 
	 * @return Script object or null if not found
	 */
	public Script getScriptObjectFromName(final String scriptFile)
	{
		return scripts.get(scriptFile);
	}

	/**
	 * Checks if any of the scripts is running.
	 * 
	 * @return True if any of the scripts is running
	 */
	public boolean areScriptsRunning()
	{
		for (final Script script : scripts.values())
		{
			if (ScriptRunningState.RUNNING.equals(script.getStatus()))
			{
				return true;
			}
		}

		return false;
	}
	
	/**
	 * Gets the scripts value.
	 *  
	 * @return The scripts value
	 */
	public Map<String, Script> getScripts()
	{
		return scripts;
	}
	
	public void addScript(final Script script)
	{
		scripts.put(script.getScriptId(), script);
	}
	
	public boolean containsScript(final Script script)
	{
		return scripts.containsKey(script.getScriptId());
	}

	/**
	 * @return the connection
	 */
	public IMqttConnection getConnection()
	{
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(IMqttConnection connection)
	{
		this.connection = connection;
	}
}
