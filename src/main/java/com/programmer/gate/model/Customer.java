package com.programmer.gate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "customer_Sequence")
	@SequenceGenerator(name = "customer_Sequence", sequenceName = "CUSTOMER_SEQ")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "limit")
	private double limit;

	public Customer(String name, double limit) {
		super();
		this.name = name;
		this.limit = limit;
	}

	public Customer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}
	
	
	
}
