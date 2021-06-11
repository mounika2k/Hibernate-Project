package com.myapp.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int roll;
	private String username;
	private String password;
	
	

	@Embedded
	private Address address;

	public Student(Long id, String name, int roll, String username, String password, Address address) {
		super();
		//this.id = id;
		this.name = name;
		this.roll = roll;
		this.username = username;
		this.password = password;
		this.address = address;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", roll=" + roll + ", username=" + username + ", address="
				+ address + "]";
	}

	

}
