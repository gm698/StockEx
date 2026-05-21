package com.stockex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.stockex.model.InventoryTransaction;
import com.stockex.service.InventoryTransactionService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryTransactionController {

	private final InventoryTransactionService transactionService;

	public InventoryTransactionController(InventoryTransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@PostMapping("/restock/{productId}")
	public InventoryTransaction restockProduct(@PathVariable Long productId, @RequestParam int quantity,
			@RequestParam(required = false) String notes) {
		return transactionService.restockProduct(productId, quantity, notes);
	}

	@PostMapping("/sale/{productId}")
	public InventoryTransaction sellProduct(@PathVariable Long productId, @RequestParam int quantity,
			@RequestParam(required = false) String notes) {
		return transactionService.sellProduct(productId, quantity, notes);
	}

	@GetMapping("/product/{productId}")
	public List<InventoryTransaction> getTransactionsByProduct(@PathVariable Long productId) {
		return transactionService.getTransactionsByProduct(productId);
	}
}
