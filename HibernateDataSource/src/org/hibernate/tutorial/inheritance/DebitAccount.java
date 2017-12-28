package org.hibernate.tutorial.inheritance;

import java.math.BigDecimal;

public class DebitAccount extends AccountType {
	private BigDecimal overdraftFee;
}
