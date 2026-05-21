package com.stockex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockex.model.Product;
import com.stockex.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
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
}
