package com.matafe.javaexamples.logging;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingMain {

	private static final Logger LOGGER = Logger.getLogger(LoggingMain.class
			.getName());

	public static void main(String[] args) throws Exception {
		LoggingMain example = new LoggingMain();

		// example.basicExample();

		example.fileExample();
	}

	void basicExample() {
		LOGGER.info("Logger Name: " + LOGGER.getName());

		LOGGER.finest("Lowest Logging Level. When you want to trace your app");
		LOGGER.finer("Next Logging Level");
		LOGGER.fine("Next Logging Level");
		LOGGER.config("Next Logging Level");
		LOGGER.info("Next Logging Level");
		LOGGER.warning("Next Logging Level");
		LOGGER.severe("Highest Logging Level. For a error on you app");

		LOGGER.log(Level.INFO, "The value ''{0}'' is invalid!",
				new Object[] { "Me" });

		String s = null;
		try {
			System.out.println(s.substring(0));// NPE here!
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Ops! Check your code!", e);
		}
	}

	void fileExample() {
		// -Djava.util.logging.config.file=logging.properties
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream(
					"logging.properties");
			LogManager.getLogManager().readConfiguration(is);
		} catch (SecurityException | IOException e) {
			throw new RuntimeException("Failed to configure the logging", e);
		}

		basicExample();
	}
}
