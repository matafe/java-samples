package com.matafe.javaexamples.designpatterns.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Configuration Manager Singleton.
 * 
 * @author matafe@gmail.com
 */
public class ConfigurationManager {

	private static final Logger LOGGER = Logger.getLogger(ConfigurationManager.class.getName());

	private static final String APP_PROPERTIES = "app.properties";

	private static final String CONFIG_FILE_SYSTEM_VAR_NAME = "app.configuration.file";

	private Properties properties = new Properties();

	/**
	 * The one and only instance of this class.
	 */
	private static ConfigurationManager instance;

	/**
	 * The private default constructor.
	 */
	private ConfigurationManager() {
		initialize();
	}

	private void initialize() {
		loadProperties();
	}

	private void loadProperties() {
		InputStream in = tryFindConfigFileFromSystemVariable();

		if (in == null) {
			in = tryFindConfigFileFromClasspath();
		}

		if (in == null) {
			throw new RuntimeException(String.format("Could not find the file '%s'", APP_PROPERTIES));
		}
		//LOGGER.info("Read all properties from file: " + APP_PROPERTIES);
		try {
			properties.load(in);
		} catch (IOException e) {
			throw new RuntimeException(String.format("Could not load the properties from file '%s'", APP_PROPERTIES));
		}
	}

	private InputStream tryFindConfigFileFromSystemVariable() {
		String configFileName = System.getProperty(CONFIG_FILE_SYSTEM_VAR_NAME);
		InputStream in = null;
		if (configFileName != null) {
			try {
				in = new FileInputStream(configFileName);
				LOGGER.info(String.format("Using the configuration file '%s' from system variable '%s'", configFileName, CONFIG_FILE_SYSTEM_VAR_NAME));
			} catch (FileNotFoundException e) {
				LOGGER.warning(String.format("Could not find the file '%s' used as system variable", configFileName));
			}
		}
		
		return in;
	}

	private InputStream tryFindConfigFileFromClasspath() {
		return this.getClass().getClassLoader().getResourceAsStream(APP_PROPERTIES);
	}

	/**
	 * Returns the singleton of this class.
	 * 
	 * @return the singleton.
	 */
	// double checked locking implementation
	public static ConfigurationManager getInstance() {
		if (instance == null) {
			synchronized (ConfigurationManager.class) {
				if (instance == null) {
					instance = new ConfigurationManager();
				}
			}
		}
		return instance;
	}

	/**
	 * Returns the value of a property.
	 * 
	 * @param propertyName
	 *            The properties name.
	 * 
	 * @return The value of the property.
	 */
	public String getProperty(final String propertyName) {
		String value = properties.getProperty(propertyName);
		if (value == null) {
			throw new RuntimeException(String.format("Property with name '%s' does not exists!", propertyName));
		}
		return value;
	}

	/**
	 * Returns all configuration properties
	 * 
	 * @param propertyName
	 *            The properties name.
	 * 
	 * @return All the properties
	 */
	public Map<String, Object> getProperties() {
		Map<String, Object> map = new HashMap<>();
		for (final String name : properties.stringPropertyNames()) {
			map.put(name, properties.getProperty(name));
		}
		return map;
	}

	public static void main(String[] args) {
		System.out.println("database.url => " + ConfigurationManager.getInstance().getProperty("database.url"));

		Map<String, Object> properties = ConfigurationManager.getInstance().getProperties();
		System.out.println(properties);
	}
}
