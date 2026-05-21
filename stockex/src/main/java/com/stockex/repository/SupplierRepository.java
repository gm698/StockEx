package com.stockex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockex.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
