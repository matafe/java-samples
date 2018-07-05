package com.matafe.javaexamples.threadlocal;

/**
 * Represents Calculator Service Implementation.
 * 
 * @author matafe@gmail.com
 */
public class CalculatorServiceImpl implements CalculatorService {

  @Override
  public int sum(int a, int b) {
    // complex and slow operation...
    int result = a + b;
    System.out.println("Executed sum for " + a + " + " + b + " = " + result);
    return result;
  }

}
