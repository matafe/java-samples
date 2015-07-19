package com.matafe.javaexamples.designpatterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author matafe@gmail.com
 */
public class Validator {

	private final List<ValidationRuleCommand> rules = new ArrayList<>();

	public Validator() {
		// default Rules.
		rules.add(new EmptyValidationRuleCommand());
		rules.add(new LargeValidationRuleCommand());
	}

	public void addValidationRule(ValidationRuleCommand rule) {
		rules.add(rule);
	}

	public List<ValidationRuleCommand> getRules() {
		return rules;
	}

	public void validate(String name) throws Exception {
		for (ValidationRuleCommand rule : rules) {
			rule.validate(name);
		}
	}

}
