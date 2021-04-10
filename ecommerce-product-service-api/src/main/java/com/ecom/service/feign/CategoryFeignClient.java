package com.ecom.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecom.model.Category;

@FeignClient(name = "ecommerce-category-api")
public interface CategoryFeignClient {

	@GetMapping("/category/{id}")
	public Category get(@PathVariable("id") Long id);
}
