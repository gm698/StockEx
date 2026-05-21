package com.stockex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockex.model.InventoryTransaction;

public interface InventoryTransactionRepository extends JpaRepository<InventoryTransaction, Long> {
	List<InventoryTransaction> findByProductId(Long productId);
}
