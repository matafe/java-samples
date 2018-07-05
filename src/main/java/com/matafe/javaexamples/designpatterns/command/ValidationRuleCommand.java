package com.matafe.javaexamples.designpatterns.command;

/**
 * @author matafe@gmail.com
 */
public interface ValidationRuleCommand {

  void validate(String name) throws Exception;
}
