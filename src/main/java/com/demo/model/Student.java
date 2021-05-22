package com.demo.model;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String name;
	
	private Integer standard;
	
	private String address;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStandard() {
		return standard;
	}

	public void setStandard(Integer standard) {
		this.standard = standard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" id: " + getId());
		stringBuilder.append(" name: " + getName());
		stringBuilder.append(" standard: " + getStandard());
		stringBuilder.append(" address: " + getAddress());
		return stringBuilder.toString();
	}
}
