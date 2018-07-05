package com.matafe.javaexamples.threadlocal;

/**
 * The main for this example.
 * 
 * @author matafe@gmail.com
 */
public class Main {

  public static void main(String[] args) {

    testWithoutCaching();

    System.out.println();
    System.out.println("=====================");
    System.out.println();

    testWithCaching();

  }

  private static void testWithCaching() {

    System.out.println("testWithCaching");

    // proxied instance
    CalculatorService calculatorService = CalculatorServiceFactory.getProxiedCalculatorService();

    // Calling 1x
    System.out.println(calculatorService.sum(1, 1));

    // Calling 2x
    System.out.println(calculatorService.sum(1, 1));

    // Calling 3x
    System.out.println(calculatorService.sum(1, 1));

    // Calling other
    System.out.println(calculatorService.sum(1, 2));

  }

  private static void testWithoutCaching() {

    System.out.println("testWithoutCaching");

    // normal instance
    CalculatorService calculatorService = CalculatorServiceFactory.getCalculatorService();

    // Calling 1x
    System.out.println(calculatorService.sum(1, 1));

    // Calling 2x
    System.out.println(calculatorService.sum(1, 1));

    // Calling 3x
    System.out.println(calculatorService.sum(1, 1));

    // Calling other
    System.out.println(calculatorService.sum(1, 2));

  }

}
