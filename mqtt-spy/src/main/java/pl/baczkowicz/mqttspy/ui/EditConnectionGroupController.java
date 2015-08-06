/***********************************************************************************
 * 
 * Copyright (c) 2014 Kamil Baczkowicz
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *    
 * The Eclipse Distribution License is available at
 *   http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 * 
 *    Kamil Baczkowicz - initial API and implementation and/or initial documentation
 *    
 */
package pl.baczkowicz.mqttspy.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.baczkowicz.mqttspy.configuration.ConfigurationManager;
import pl.baczkowicz.mqttspy.configuration.ConfigurationUtils;
import pl.baczkowicz.mqttspy.configuration.ConfiguredConnectionDetails;
import pl.baczkowicz.mqttspy.configuration.generated.UserInterfaceMqttConnectionDetails;
import pl.baczkowicz.mqttspy.exceptions.ConfigurationException;
import pl.baczkowicz.mqttspy.ui.connections.ConnectionManager;

/**
 * Controller for editing a single connection.
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class EditConnectionGroupController extends AnchorPane implements Initializable
{
	final static Logger logger = LoggerFactory.getLogger(EditConnectionGroupController.class);
	
	@FXML
	private TextField connectionGroupNameText;
	
	// Action buttons
	
	@FXML
	private Button connectButton;
	
	@FXML
	private Button saveButton;
	
	@FXML
	private Button undoButton;
	
	// Other fields

	private MainController mainController;
	
	// ===============================
	// === Initialisation ============
	// ===============================

	public void initialize(URL location, ResourceBundle resources)
	{
		connectionGroupNameText.textProperty().addListener(new ChangeListener()
		{
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue)
			{
				onChange();
			}		
		});		
	}

	public void init()
	{
	}

	// ===============================
	// === FXML ======================
	// ===============================
	
	@FXML
	private void undo()
	{
//		editedConnectionDetails.undo();
//		editConnectionsController.listConnections();
//		
//		// Note: listing connections should display the existing one
//		
//		updateButtons();
	}
	
	
	@FXML
	private void save()
	{
//		editedConnectionDetails.apply();
//		editConnectionsController.listConnections();
//				
//		updateButtons();
//		
//		logger.debug("Saving connection " + getConnectionName().getText());
//		if (configurationManager.saveConfiguration())
//		{
//			DialogUtils.showTooltip(saveButton, "Changes for connection " + editedConnectionDetails.getName() + " have been saved.");
//		}
	}	
	
	@FXML
	public void createConnection() throws ConfigurationException
	{
//		readAndDetectChanges();
//		final String validationResult = ConnectivityUtils.validateConnectionDetails(editedConnectionDetails, false);
//		
//		if (validationResult != null)
//		{
//			DialogUtils.showValidationWarning(validationResult);
//		}
//		else
//		{					
//			if (editedConnectionDetails.isModified())
//			{	
//				Action response = DialogUtils.showApplyChangesQuestion("connection " + editedConnectionDetails.getName()); 
//				if (response == Dialog.ACTION_YES)
//				{
//					save();
//				}
//				else if (response == Dialog.ACTION_NO)
//				{
//					// Do nothing
//				}
//				else
//				{
//					return;
//				}
//			}
//			
//			if (!openNewMode)
//			{
//				connectionManager.disconnectAndCloseTab(existingConnection);
//			}
//			
//			logger.info("Opening connection " + getConnectionName().getText());
//	
//			// Get a handle to the stage
//			Stage stage = (Stage) connectButton.getScene().getWindow();
//	
//			// Close the window
//			stage.close();
//	 
//			Platform.runLater(new Runnable()
//			{
//				@Override
//				public void run()
//				{
//					try
//					{						
//						connectionManager.openConnection(editedConnectionDetails, getMainController());
//					}
//					catch (ConfigurationException e)
//					{
//						// TODO: show warning dialog for invalid
//						logger.error("Cannot open conection {}", editedConnectionDetails.getName(), e);
//					}					
//				}				
//			});
//			
//		}
	}

	// ===============================
	// === Logic =====================
	// ===============================
	
	public void onChange()
	{
//		if (recordModifications && !emptyConnectionList)
//		{					
//			if (readAndDetectChanges())
//			{
//				updateButtons();
//				editConnectionConnectivityController.updateClientId(false);
//				editConnectionConnectivityController.updateClientIdLength();
//				updateConnectionName();		
//				editConnectionConnectivityController.updateReconnection();
//				editConnectionSecurityController.updateUserAuthentication();
//				editConnectionsController.listConnections();
//			}
//		}				
	}

	private UserInterfaceMqttConnectionDetails readValues()
	{
		final UserInterfaceMqttConnectionDetails connection = new UserInterfaceMqttConnectionDetails();
//		connection.setMessageLog(new MessageLog());
//		
//		// Populate the default for the values we don't display / are not used
//		ConfigurationUtils.populateConnectionDefaults(connection);
//		
//		connection.setName(connectionNameText.getText());
//		connection.setProtocol(protocolCombo.getSelectionModel().getSelectedItem());
//		
//		editConnectionConnectivityController.readValues(connection);
//		editConnectionOtherController.readValues(connection);
//		editConnectionSecurityController.readValues(connection);
//		editConnectionMessageLogController.readValues(connection);
//		editConnectionPublicationsController.readValues(connection);
//		editConnectionSubscriptionsController.readValues(connection);
//		editConnectionLastWillController.readValues(connection);			
		
		return connection;
	}
//	
//	private boolean readAndDetectChanges()
//	{
//		final UserInterfaceMqttConnectionDetails connection = readValues();
//		boolean changed = !connection.equals(editedConnectionDetails.getSavedValues());
//			
//		logger.debug("Values read. Changed = " + changed);
//		editedConnectionDetails.setModified(changed);
//		editedConnectionDetails.setConnectionDetails(connection);
//		
//		return changed;
//	}

	public void editConnection(final ConfiguredConnectionDetails connectionDetails)
	{	
//		synchronized (this)
//		{
//			this.editedConnectionDetails = connectionDetails;
//			
//			// Set 'open connection' button mode
//			openNewMode = true;
//			existingConnection = null;
//			connectButton.setText("Open connection");
//			
//			logger.debug("Editing connection id={} name={}", editedConnectionDetails.getId(),
//					editedConnectionDetails.getName());
//			for (final MqttAsyncConnection mqttConnection : connectionManager.getConnections())
//			{
//				if (connectionDetails.getId() == mqttConnection.getProperties().getConfiguredProperties().getId() && mqttConnection.isOpened())
//				{
//					openNewMode = false;
//					existingConnection = mqttConnection;
//					connectButton.setText("Close and re-open existing connection");
//					break;
//				}				
//			}
//			
//			if (editedConnectionDetails.getName().equals(
//					ConnectionUtils.composeConnectionName(editedConnectionDetails.getClientID(), editedConnectionDetails.getServerURI())))
//			{
//				lastGeneratedConnectionName = editedConnectionDetails.getName();
//			}
//			else
//			{
//				lastGeneratedConnectionName = "";
//			}
//			
//			displayConnectionDetails(editedConnectionDetails);		
//			editConnectionConnectivityController.updateClientIdLength();
//			updateConnectionName();
//						
//			updateButtons();
//		}
	}
	
	private void updateButtons()
	{
//		if (editedConnectionDetails != null && editedConnectionDetails.isModified())
//		{
//			saveButton.setDisable(false);
//			undoButton.setDisable(false);
//		}
//		else
//		{
//			saveButton.setDisable(true);
//			undoButton.setDisable(true);
//		}
	}
	
	private void displayConnectionDetails(final ConfiguredConnectionDetails connection)
	{
		ConfigurationUtils.populateConnectionDefaults(connection);
		
//		connectionNameText.setText(connection.getName());
//		protocolCombo.getSelectionModel().select(connection.getProtocol());
//		
//		editConnectionConnectivityController.displayConnectionDetails(connection);
//		editConnectionSecurityController.displayConnectionDetails(connection);
//		editConnectionMessageLogController.displayConnectionDetails(connection);
//		editConnectionOtherController.displayConnectionDetails(connection);
//		editConnectionPublicationsController.displayConnectionDetails(connection);
//		editConnectionSubscriptionsController.displayConnectionDetails(connection);
//		editConnectionLastWillController.displayConnectionDetails(connection);
//		
		connection.setBeingCreated(false);
	}		

	// ===============================
	// === Setters and getters =======
	// ===============================
	
	public void setMainController(MainController mainController)
	{
		this.mainController = mainController;
	}
	
	public void setRecordModifications(boolean recordModifications)
	{
//		if (!recordModifications)
//		{
//			logger.trace("Modifications suspended...");
//			noModificationsLock++;
//			this.recordModifications = recordModifications;
//		}
//		else
//		{ 
//			noModificationsLock--;
//			// Only allow modifications once the parent caller removes the lock
//			if (noModificationsLock == 0)
//			{
//				logger.trace("Modifications restored...");
//				this.recordModifications = recordModifications;
//			}
//		}
	}
	
//	public boolean isRecordModifications()	
//	{
//		return recordModifications;
//	}

//	public TextField getConnectionName()
//	{
//		return connectionNameText;
//	}
//	
//	public ConfiguredConnectionDetails getEditedConnectionDetails()
//	{
//		return editedConnectionDetails;
//	}

	/**
	 * @return the mainController
	 */
	public MainController getMainController()
	{
		return mainController;
	}
}
