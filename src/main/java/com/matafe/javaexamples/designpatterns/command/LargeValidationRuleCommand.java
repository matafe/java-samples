package com.matafe.javaexamples.designpatterns.command;

/**
 * @author matafe@gmail.com
 */
public class LargeValidationRuleCommand implements ValidationRuleCommand {

	private static final int THRESHOLD_SIZE = 20;

	@Override
	public void validate(String name) {
		if (name != null && name.length() > THRESHOLD_SIZE) {
			int curLength = name == null ? 0 : name.length();
			throw new RuntimeException("Name must not be greather than "
					+ THRESHOLD_SIZE + ". Actual length is " + curLength + "!");
		}
	}

}
