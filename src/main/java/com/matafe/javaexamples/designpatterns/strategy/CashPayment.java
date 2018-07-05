package com.matafe.javaexamples.designpatterns.strategy;

import java.math.BigDecimal;

/**
 * @author matafe@gmail.com
 */
public class CashPayment implements PaymentStrategy {

  @Override
  public void pay(BigDecimal value) {
    System.out.println("$" + value + " paid with cash");
  }

}
