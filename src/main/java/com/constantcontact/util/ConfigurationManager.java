package com.constantcontact.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Configuration Manager which provides properties from application configuration file in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public final class ConfigurationManager {
	private static final ConfigurationManager instance;
	private static final String CONFIG_FILE_URI = "app.config";
	private Properties configs;

	static {
		instance = new ConfigurationManager();
		instance.init();
	}

	/**
	 * Provides configuration property by key.
	 * 
	 * @param key Name of the property.
	 * @return <code>String</code> property value.
	 */
	public static String getAppSettings(String key) {
		return instance.configs.getProperty(key);
	}

	/**
	 * Default constructor.<br/>
	 * Made private since we are using a Singleton.
	 */
	private ConfigurationManager() {
		super();
		configs = new Properties();
	}

	/**
	 * Initializes configuration from application configuration file.
	 */
	private void init() {
		InputStream configsStream = this.getClass().getClassLoader().getResourceAsStream(CONFIG_FILE_URI);
		try {
			configs.load(configsStream);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
