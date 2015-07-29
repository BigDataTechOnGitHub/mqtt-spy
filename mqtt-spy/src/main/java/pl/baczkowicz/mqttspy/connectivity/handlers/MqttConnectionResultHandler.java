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
package pl.baczkowicz.mqttspy.connectivity.handlers;

import javafx.application.Platform;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.baczkowicz.mqttspy.connectivity.MqttAsyncConnection;
import pl.baczkowicz.mqttspy.stats.StatisticsManager;
import pl.baczkowicz.mqttspy.ui.events.queuable.connectivity.MqttConnectionAttemptFailureEvent;
import pl.baczkowicz.mqttspy.ui.events.queuable.connectivity.MqttConnectionAttemptSuccessEvent;

public class MqttConnectionResultHandler implements IMqttActionListener
{
	private final static Logger logger = LoggerFactory.getLogger(MqttConnectionResultHandler.class);

	public void onSuccess(IMqttToken asyncActionToken)
	{
		final MqttAsyncConnection connection = (MqttAsyncConnection) asyncActionToken.getUserContext();
		StatisticsManager.newConnection();
		Platform.runLater(new MqttEventHandler(new MqttConnectionAttemptSuccessEvent(connection)));
		logger.info(connection.getProperties().getName() + " connected");
	}

	public void onFailure(IMqttToken asyncActionToken, Throwable exception)
	{
		final MqttAsyncConnection connection = (MqttAsyncConnection) asyncActionToken.getUserContext();
		Platform.runLater(new MqttEventHandler(new MqttConnectionAttemptFailureEvent(connection, exception)));
		logger.warn("Connecting to " + connection.getProperties().getName() + " failed", exception);
	}
}
