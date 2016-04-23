/***********************************************************************************
 * 
 * Copyright (c) 2015 Kamil Baczkowicz
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

package pl.baczkowicz.spy.ui.events;

import pl.baczkowicz.spy.connectivity.ConnectionStatus;
import pl.baczkowicz.spy.eventbus.FilterableEvent;

public class ConnectionStatusChangeEvent extends FilterableEvent
{
	private String name;
	
	private ConnectionStatus status;

	public ConnectionStatusChangeEvent(final Object changedConnection, final String name, final ConnectionStatus status)
	{
		this.setFilter(changedConnection);
		
		this.name = name;
		this.status = status;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public ConnectionStatus getConnectionStatus()
	{
		return status;
	}
}
