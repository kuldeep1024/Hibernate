package com.mapping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phone")
public class Phone {
	private int phone_id;
	private String phone_type;
	private String phone_number;

	public Phone() {
		super();
	}
	

	public Phone(String phone_type, String phone_number) {
		super();
		this.phone_type = phone_type;
		this.phone_number = phone_number;
	}


	@Id
	@GeneratedValue
	public int getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}

	public String getPhone_type() {
		return phone_type;
	}

	public void setPhone_type(String phone_type) {
		this.phone_type = phone_type;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

}
