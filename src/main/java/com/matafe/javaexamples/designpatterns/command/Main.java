package com.matafe.javaexamples.designpatterns.command;

/**
 * @author matafe@gmail.com
 */
public class Main {

	public static void main(String[] args) {

		Validator validator = new Validator();

		try {
			// OK
			validator.validate("Me");
			System.out.println("Name Me OK!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			// NOT OK
			validator.validate(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			// NOT OK
			validator.validate("");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			// NOT OK
			validator.validate("This is a big text file in a name");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// New Rule.
		validator.addValidationRule(new ValidationRuleCommand() {

			@Override
			public void validate(String name) throws Exception {
				if (name != null && name.toUpperCase().contains("TEST")) {
					throw new RuntimeException("Name must not contains TEST!");
				}
			}
		});

		try {
			// NOT OK
			validator.validate("This is TEST name");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
