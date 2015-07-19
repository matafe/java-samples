package com.matafe.javaexamples.designpatterns.strategy;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author matafe@gmail.com
 */
class CreditCardPayment implements PaymentStrategy {

	private String number;

	private String holderName;

	private Date expireDate;

	private CreditCardType type;

	public CreditCardPayment(String number, String holderName, Date expireDate,
			CreditCardType type) {
		super();
		this.number = number;
		this.holderName = holderName;
		this.expireDate = expireDate;
		this.type = type;
	}

	@Override
	public void pay(BigDecimal value) {
		System.out.println("$" + value + " paid with credit card number "
				+ number + " of " + holderName);
	}

	public String getNumber() {
		return number;
	}

	public String getHolderName() {
		return holderName;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public CreditCardType getType() {
		return type;
	}

}

enum CreditCardType {
	VISA, MASTERCARD
}
