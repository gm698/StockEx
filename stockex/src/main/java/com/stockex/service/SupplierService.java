package com.stockex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockex.model.Supplier;
import com.stockex.repository.SupplierRepository;

@Service
public class SupplierService {
	private final SupplierRepository supplierRepository;

	public SupplierService(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}

	public Supplier createSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	public Supplier getSupplierById(Long id) {
		return supplierRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
	}

	public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
		Supplier supplier = getSupplierById(id);

		supplier.setName(updatedSupplier.getName());
		supplier.setPhone(updatedSupplier.getPhone());
		supplier.setEmail(updatedSupplier.getEmail());
		supplier.setAddress(updatedSupplier.getAddress());

		return supplierRepository.save(supplier);
	}

	public void deleteSupplier(Long id) {
		Supplier supplier = getSupplierById(id);
		supplierRepository.delete(supplier);
	}
}
