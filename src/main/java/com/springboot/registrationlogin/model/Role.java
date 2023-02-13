package com.springboot.registrationlogin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Role JPA Entity
@Entity
@Table(name = "role")
public class Role {
	
	@Id // sets field as primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // provides a primary key generation strategy
	private Long id;
	private String name;
	
	public Role() {
		
	}
	
	public Role(String name) {
		super();
		this.name = name;
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
	
	
}
