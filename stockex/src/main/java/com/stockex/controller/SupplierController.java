package com.stockex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.stockex.model.Supplier;
import com.stockex.service.SupplierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
	private final SupplierService supplierService;

	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	@GetMapping
	public List<Supplier> getAllSuppliers() {
		return supplierService.getAllSuppliers();
	}

	@PostMapping
	public Supplier createSupplier(@Valid @RequestBody Supplier supplier) {
		return supplierService.createSupplier(supplier);
	}

	@GetMapping("/{id}")
	public Supplier getSupplierById(@PathVariable Long id) {
		return supplierService.getSupplierById(id);
	}

	@PutMapping("/{id}")
	public Supplier updateSupplier(@PathVariable Long id, @Valid @RequestBody Supplier supplier) {
		return supplierService.updateSupplier(id, supplier);
	}

	@DeleteMapping("/{id}")
	public String deleteSupplier(@PathVariable Long id) {
		supplierService.deleteSupplier(id);
		return "Supplier deleted successfully";
	}
}
