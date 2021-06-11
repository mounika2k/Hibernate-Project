package com.myapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product { // entity class
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // Consider this as primary key and auto increment
	private String title;
	@Column(length = 10000)
	private String description;
	@Column(name = "price")
	private double price;

	@OneToOne
	private Category category; // Category table take pk(category_id) add it as a foreign key in product table

	

	public Product(Long id, String title, String description, double price) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		
	}

	public Product() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", category=" + category + "]";
	}

	

	

}
