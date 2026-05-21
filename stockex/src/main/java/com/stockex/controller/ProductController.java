package com.stockex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.stockex.model.Product;
import com.stockex.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	@PostMapping
	public Product createProduct(@Valid @RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return "Product deleted successfully";
	}

	@PutMapping("/{productId}/supplier/{supplierId}")
	public Product assignSupplierToProduct(@PathVariable Long productId, @PathVariable Long supplierId) {
		return productService.assignSupplierToProduct(productId, supplierId);
	}

}
