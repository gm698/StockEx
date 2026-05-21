package com.stockex.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "inventory_transactions")
public class InventoryTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Transaction type is required")
	private String transactionType;

	@Positive(message = "Quantity changed must be greater than 0")
	private int quantityChanged;

	private String notes;

	private LocalDateTime transactionDate;

	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonIgnore
	private Product product;

	public InventoryTransaction() {
		this.transactionDate = LocalDateTime.now();
	}

	public InventoryTransaction(String transactionType, int quantityChanged, String notes, Product product) {
		this.transactionType = transactionType;
		this.quantityChanged = quantityChanged;
		this.notes = notes;
		this.product = product;
		this.transactionDate = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getQuantityChanged() {
		return quantityChanged;
	}

	public void setQuantityChanged(int quantityChanged) {
		this.quantityChanged = quantityChanged;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
