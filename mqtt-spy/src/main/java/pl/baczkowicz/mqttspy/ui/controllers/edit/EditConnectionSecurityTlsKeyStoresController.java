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
package pl.baczkowicz.mqttspy.ui.controllers.edit;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import pl.baczkowicz.mqttspy.common.generated.SslSettings;
import pl.baczkowicz.mqttspy.configuration.ConfiguredConnectionDetails;
import pl.baczkowicz.mqttspy.configuration.generated.UserInterfaceMqttConnectionDetails;
import pl.baczkowicz.mqttspy.ui.EditConnectionController;
import pl.baczkowicz.spy.common.generated.SecureSocketModeEnum;

/**
 * Controller for editing a single connection - security tab.
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class EditConnectionSecurityTlsKeyStoresController extends AnchorPane implements Initializable
{
	/** The parent controller. */
	private EditConnectionController parent;
	
	@FXML
	private AnchorPane tlsKeyStoresPane;
	
	// Key stores
	
	@FXML
	private TextField serverKeyStoreFile;
	
	@FXML
	private TextField serverKeyStorePassword;
	
	@FXML
	private TextField clientKeyStoreFile;
	
	@FXML
	private TextField clientKeyStorePassword;
	
	@FXML
	private TextField clientKeyPassword;	
	
	@FXML
	private Label clientKeyPasswordLabel;
	
	@FXML
	private Label clientKeyStorePasswordLabel;
	
	@FXML
	private Label clientKeyFileLabel;

	@FXML
	private Button editServerKeyStoreFileButton;
	
	@FXML
	private Button editClientKeyStoreFileButton;

	private final ChangeListener basicOnChangeListener = new ChangeListener()
	{
		@Override
		public void changed(ObservableValue observable, Object oldValue, Object newValue)
		{
			onChange();			
		}		
	};
	
	// ===============================
	// === Initialisation ============
	// ===============================

	public void initialize(URL location, ResourceBundle resources)
	{		
		// Key stores
		serverKeyStoreFile.textProperty().addListener(basicOnChangeListener);
		serverKeyStorePassword.textProperty().addListener(basicOnChangeListener);
		clientKeyStoreFile.textProperty().addListener(basicOnChangeListener);
		clientKeyStorePassword.textProperty().addListener(basicOnChangeListener);
		clientKeyPassword.textProperty().addListener(basicOnChangeListener);	
	}

	public void init()
	{
		// Nothing to do
	}

	// ===============================
	// === Logic =====================
	// ===============================

	public void onChange()
	{	
		parent.onChange();
	}
	
	public void updateSSL(final SecureSocketModeEnum mode)
	{
		final boolean keyStores = SecureSocketModeEnum.SERVER_KEYSTORE.equals(mode)
				|| SecureSocketModeEnum.SERVER_AND_CLIENT_KEYSTORES.equals(mode);
		
		if (keyStores)
		{
			final boolean serverAndClient = SecureSocketModeEnum.SERVER_AND_CLIENT_KEYSTORES.equals(mode);	
			clientKeyStoreFile.setVisible(serverAndClient);
			clientKeyStorePassword.setVisible(serverAndClient);
			clientKeyPassword.setVisible(serverAndClient);	
			editClientKeyStoreFileButton.setVisible(serverAndClient);
			
			clientKeyPasswordLabel.setVisible(serverAndClient);
			clientKeyStorePasswordLabel.setVisible(serverAndClient);			
			clientKeyFileLabel.setVisible(serverAndClient);
		}
	}

	public void readAndSetValues(final SecureSocketModeEnum mode, final UserInterfaceMqttConnectionDetails connection)
	{
		
		if (mode == null || SecureSocketModeEnum.DISABLED.equals(mode))
		{
			connection.setSSL(null);
		}		
		else
		{
			final SslSettings sslSettings = connection.getSSL();
			
			final boolean keyStores = SecureSocketModeEnum.SERVER_KEYSTORE.equals(mode)
					|| SecureSocketModeEnum.SERVER_AND_CLIENT_KEYSTORES.equals(mode);
			
			if (keyStores)
			{
				sslSettings.setServerKeyStoreFile(serverKeyStoreFile.getText());
				sslSettings.setServerKeyStorePassword(serverKeyStorePassword.getText());				
				sslSettings.setClientKeyStoreFile(clientKeyStoreFile.getText());
				sslSettings.setClientKeyStorePassword(clientKeyStorePassword.getText());
				sslSettings.setClientKeyPassword(clientKeyPassword.getText());
			}
			
			connection.setSSL(sslSettings);
		}
	}
	
	public void displayConnectionDetails(final ConfiguredConnectionDetails connection)
	{
		if (connection.getSSL() != null)
		{
			// Key stores
			serverKeyStoreFile.setText(connection.getSSL().getServerKeyStoreFile());
			serverKeyStorePassword.setText(connection.getSSL().getServerKeyStorePassword());				
			clientKeyStoreFile.setText(connection.getSSL().getClientKeyStoreFile());
			clientKeyStorePassword.setText(connection.getSSL().getClientKeyStorePassword());
			clientKeyPassword.setText(connection.getSSL().getClientKeyPassword());
		}			
	}	
	
	@FXML
	private void editServerKeyStoreFile()
	{
		// TODO
	}
	
	@FXML
	private void editClientKeyStoreFile()
	{
		// TODO
	}

	// ===============================
	// === Setters and getters =======
	// ===============================
	
	public void setParent(final EditConnectionController controller)
	{
		this.parent = controller;
	}

	/**
	 * @return the tlsKeyStoresPane
	 */
	public AnchorPane getTlsKeyStoresPane()
	{
		return tlsKeyStoresPane;
	}

	/**
	 * @param tlsKeyStoresPane the tlsKeyStoresPane to set
	 */
	public void setTlsKeyStoresPane(AnchorPane tlsKeyStoresPane)
	{
		this.tlsKeyStoresPane = tlsKeyStoresPane;
	}
}