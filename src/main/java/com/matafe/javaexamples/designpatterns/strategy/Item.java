package com.matafe.javaexamples.designpatterns.strategy;

import java.math.BigDecimal;

/**
 * @author matafe@gmail.com
 */
final class Item {

  private String name;

  private BigDecimal price;

  public Item(String name, BigDecimal price) {
    super();
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Item [name=" + name + ", price=$" + price + "]";
  }

}
