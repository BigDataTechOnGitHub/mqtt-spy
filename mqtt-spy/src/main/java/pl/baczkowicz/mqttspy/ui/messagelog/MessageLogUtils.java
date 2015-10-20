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
package pl.baczkowicz.mqttspy.ui.messagelog;

import java.util.Collection;
import java.util.List;

import pl.baczkowicz.mqttspy.common.generated.MessageLog;
import pl.baczkowicz.mqttspy.common.generated.MessageLogEnum;
import pl.baczkowicz.mqttspy.logger.SimpleMqttMessageLogComposer;
import pl.baczkowicz.mqttspy.messages.FormattedMqttMessage;
import pl.baczkowicz.spy.ui.storage.BasicMessageStoreWithSummary;

public class MessageLogUtils
{
	public static String getCurrentMessageAsMessageLog(final BasicMessageStoreWithSummary<FormattedMqttMessage> store, final int messageIndex)
	{
		final FormattedMqttMessage message = store.getMessages().get(messageIndex);
		return SimpleMqttMessageLogComposer.createReceivedMessageLog(message, 
				new MessageLog(MessageLogEnum.XML_WITH_PLAIN_PAYLOAD, "", true, true, false, false, false));
	}
	
	public static String getAllMessagesAsMessageLog(final BasicMessageStoreWithSummary<FormattedMqttMessage> store)
	{
		final StringBuffer messagesAsString = new StringBuffer();
		
		final List<FormattedMqttMessage> messages = store.getMessages(); 
		for (int i = messages.size() - 1; i >= 0; i--)
		{
			final FormattedMqttMessage message = messages.get(i);
			
			messagesAsString.append(SimpleMqttMessageLogComposer.createReceivedMessageLog(message, 
					new MessageLog(MessageLogEnum.XML_WITH_PLAIN_PAYLOAD, "", true, true, false, false, false)));
			messagesAsString.append(System.lineSeparator());
		}
		
		return messagesAsString.toString();
	}
	
	public static String getAllTopicsAsString(final Collection<String> topics)
	{
		final StringBuffer messages = new StringBuffer();
		
		for (final String topic : topics)
		{
			messages.append(topic);
			messages.append(System.lineSeparator());
		}
		
		return messages.toString();
	}
}
