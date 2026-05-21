package com.stockex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockex.model.Product;
import com.stockex.model.Supplier;
import com.stockex.repository.ProductRepository;
import com.stockex.repository.SupplierRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final SupplierRepository supplierRepository;

	public ProductService(ProductRepository productRepository, SupplierRepository supplierRepository) {
		this.productRepository = productRepository;
		this.supplierRepository = supplierRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Long id, Product updatedProduct) {

		Product product = getProductById(id);

		product.setName(updatedProduct.getName());
		product.setSku(updatedProduct.getSku());
		product.setCategory(updatedProduct.getCategory());
		product.setPrice(updatedProduct.getPrice());
		product.setQuantity(updatedProduct.getQuantity());

		return productRepository.save(product);
	}

	public void deleteProduct(Long id) {
		Product product = getProductById(id);
		productRepository.delete(product);
	}

	public Product assignSupplierToProduct(Long productId, Long supplierId) {
		Product product = getProductById(productId);

		Supplier supplier = supplierRepository.findById(supplierId)
				.orElseThrow(() -> new RuntimeException("Supplier not found with id: " + supplierId));

		product.setSupplier(supplier);

		return productRepository.save(product);
	}
}
