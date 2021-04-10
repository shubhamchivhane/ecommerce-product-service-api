package com.ecom.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecom.dao.ProductRepository;
import com.ecom.model.Product;

@Service
public interface ProductService {

	public Product save(Product product);

	public Optional<Product> getProduct(Long productId);

	public void deleteProduct(Long productId);

}