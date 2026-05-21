package com.stockex.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Product name is required")
	private String name;

	@NotBlank(message = "SKU is required")
	private String sku;

	@NotBlank(message = "Category is required")
	private String category;

	@Positive(message = "Price must be greater than 0")
	private double price;

	@PositiveOrZero(message = "Quantity cannot be negative")
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

	public Product() {

	}

	public Product(String name, String sku, String category, double price, int quantity) {
		this.name = name;
		this.sku = sku;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
