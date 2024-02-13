package com.banking.manage.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class AccountDto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private double amount;
	

	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AccountDto(long id, String name, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "AccountDto [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}

}
