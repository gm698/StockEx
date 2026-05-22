package com.stockex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockex.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByQuantityLessThanEqual(int quantity);
}
