package com.example.demo.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;

@Entity
@Document(collection="customers") 
public class Customer {
	
	private String name;
	private int age;
	private String telno;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer( String name, int age, String telno) {
		super();
		this.name = name;
		this.age = age;
		this.telno = telno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
}
