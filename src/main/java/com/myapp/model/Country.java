package com.myapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//creates country table

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)//creates 3 tables only id will be propogated into other tables also.
public class Country {
	@Id
	private Long countryId;
	
	private String gdp;
	

}
