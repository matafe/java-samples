package com.matafe.javaexamples.designpatterns.strategy;

import java.math.BigDecimal;
import java.util.Date;

public class Main {

  public static void main(String[] args) {

    ShoppingCart sc = new ShoppingCart();

    sc.addItem(new Item("TV", new BigDecimal(1000)));
    sc.addItem(new Item("DVD Player", new BigDecimal(300)));
    sc.addItem(new Item("Home Theater", new BigDecimal(500)));

    sc.showItems();

    System.out.println();

    // Credit Card payment
    sc.pay(new CreditCardPayment("12345", "Me", new Date(), CreditCardType.VISA));

    // Cash payment
    sc.pay(new CashPayment());

  }
}
