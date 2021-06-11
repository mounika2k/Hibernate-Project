package com.myapp.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String street;
	
	private String city;
	private String pincode;
	public Address(String street, String city, String pincode) {
		super();
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}
	public Address() {
		super();
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	

}
