package com.ecom.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.exception.Http400Exception;
import com.ecom.model.Product;
import com.ecom.service.ProductService;

@RestController
@RequestMapping("/pdp-service")
public class ProductController {

	Logger logger = LoggerFactory.getLogger("ProductController");

	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/product")
	public ResponseEntity<?> createProduct(@RequestBody Product product) {
		logger.info("createproduct controller :"+product);
		try {
			Product productSaved = productService.save(product);
			logger.info("Product Saved :" + productSaved.toString());
			return ResponseEntity.ok("New Product has been saved with Id: " + productSaved.getId());
		} catch (Exception e) {
			throw new Http400Exception("The Request did not have proper data", e);
		}
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> get(@PathVariable("id") Long id) {

		try {
			Optional<Product> productRetrieved = productService.getProduct(id);
			Product product = productRetrieved.get();
			return ResponseEntity.ok().body(product);

		} catch (Exception e) {

			throw new Http400Exception("Resource not found with id :" + id, e);
		}
	}

//	@GetMapping("solcommerce/pdp-service/product/bypage")
//	Page<Product> getProductsByPage(
//			@RequestParam(value = "pagenumber", required = true, defaultValue = "0") Integer pageNumber,
//			@RequestParam(value = "pagesize", required = true, defaultValue = "20") Integer pageSize) {
//		return productService.getProductByPage(pageNumber, pageSize);
//	}

	@PutMapping("/product/{id}")
	@ResponseBody
	public Product updateProduct(@RequestBody Product product) {
		Product productUpdated = productService.save(product);

		logger.info("Product Saved :" + productUpdated.toString());
		return product;
	}

	/*---Delete a Product by id---*/
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok().body("Product has been deleted successfully.");
	}
}