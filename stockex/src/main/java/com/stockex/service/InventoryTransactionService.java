package com.stockex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockex.enums.TransactionType;
import com.stockex.model.InventoryTransaction;
import com.stockex.model.Product;
import com.stockex.repository.InventoryTransactionRepository;

@Service
public class InventoryTransactionService {
	private final InventoryTransactionRepository transactionRepository;
	private final ProductService productService;

	public InventoryTransactionService(InventoryTransactionRepository transactionRepository,
			ProductService productService) {
		this.transactionRepository = transactionRepository;
		this.productService = productService;
	}

	public InventoryTransaction restockProduct(Long productId, int quantity, String notes) {
		Product product = productService.getProductById(productId);

		product.setQuantity(product.getQuantity() + quantity);
		productService.saveProduct(product);

		InventoryTransaction transaction = new InventoryTransaction(TransactionType.RESTOCK, quantity, notes, product);
		return transactionRepository.save(transaction);
	}

	public InventoryTransaction sellProduct(Long productId, int quantity, String notes) {
		Product product = productService.getProductById(productId);

		if (product.getQuantity() < quantity) {
			throw new RuntimeException("Not enough stock available");
		}

		product.setQuantity(product.getQuantity() - quantity);
		productService.saveProduct(product);

		InventoryTransaction transaction = new InventoryTransaction(TransactionType.SALE, quantity, notes, product);

		return transactionRepository.save(transaction);
	}

	public List<InventoryTransaction> getTransactionsByProduct(Long productId) {
		return transactionRepository.findByProductId(productId);
	}
}
