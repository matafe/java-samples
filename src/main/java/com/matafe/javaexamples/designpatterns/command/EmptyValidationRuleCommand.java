package com.matafe.javaexamples.designpatterns.command;

/**
 * @author matafe@gmail.com
 */
public class EmptyValidationRuleCommand implements ValidationRuleCommand {

	@Override
	public void validate(String name) {
		if (name == null || name.isEmpty()) {
			throw new RuntimeException("Name must not be empty!");
		}
	}

}
