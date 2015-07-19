package com.matafe.javaexamples.designpatterns.strategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author matafe@gmail.com
 */
class ShoppingCart {

	private List<Item> items = new ArrayList<>();

	public List<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		getItems().add(item);
	}

	public void removeItem(Item item) {
		getItems().remove(item);
	}

	public void removeAllItem() {
		getItems().clear();
	}

	public BigDecimal getTotalPrice() {
		BigDecimal tot = BigDecimal.ZERO;

		for (Item item : items) {
			tot = tot.add(item.getPrice());
		}

		return tot;
	}

	public void showItems() {
		for (int i = 0; i < getItems().size(); i++) {
			Item item = getItems().get(i);
			System.out.println((i + 1) + " - " + item);

		}
	}

	public void pay(PaymentStrategy paymentMethod) {
		paymentMethod.pay(getTotalPrice());
	}

	@Override
	public String toString() {
		return "ShoppingCart [items.size=" + items.size() + "]";
	}

}
