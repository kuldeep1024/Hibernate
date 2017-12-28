package org.hibernate.tutorial.inheritance;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AccountType {
	@Id
    private Long id;

    private String owner;

    private BigDecimal balance;

    private BigDecimal interestRate;
}
