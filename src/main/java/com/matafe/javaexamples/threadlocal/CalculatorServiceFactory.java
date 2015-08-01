package com.matafe.javaexamples.threadlocal;

/**
 * This is a <strong>Factory Method</strong> design pattern for the Calculator
 * Service.
 * 
 * @author matafe@gmail.com
 */
public class CalculatorServiceFactory {

	/**
	 * Returns the Calculator Service Implementation.
	 * 
	 * @return The Calculator Service Implementation.
	 */
	public static CalculatorService getCalculatorService() {
		return new CalculatorServiceImpl();
	}

	/**
	 * Returns the Proxied Calculator Service Implementation.
	 * 
	 * @return The Proxied Calculator Service Implementation.
	 */
	public static CalculatorService getProxiedCalculatorService() {
		// proxied instance
		return (CalculatorService) CacheProxy
				.newInstance(getCalculatorService());
	}
}
