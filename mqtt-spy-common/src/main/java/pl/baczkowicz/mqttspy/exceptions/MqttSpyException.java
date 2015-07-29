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
package pl.baczkowicz.mqttspy.exceptions;

/**
 * Represents a base exception.
 */
public class MqttSpyException extends Exception
{
	/** Generated serialVersionUID */
	private static final long serialVersionUID = -1041373917140441043L;

	public MqttSpyException(String error)
	{
		super(error);
	}
	
	public MqttSpyException(String error, Throwable e)
	{
		super(error, e);
	}
}
