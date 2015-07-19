package com.matafe.javaexamples.designpatterns.strategy;

import java.math.BigDecimal;

/**
 * @author matafe@gmail.com
 */
interface PaymentStrategy {

	void pay(BigDecimal value);

}
