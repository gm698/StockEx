package com.stockex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockex.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
