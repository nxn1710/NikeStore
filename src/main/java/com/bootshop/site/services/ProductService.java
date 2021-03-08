package com.bootshop.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

import com.bootshop.site.entities.Product;
import com.bootshop.site.repositories.ProductRepository;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	public Page<Product> getListProducts(Integer pageNumber, Integer productPerPage, Integer categoryId) {
		Pageable pageable = PageRequest.of(pageNumber-1, productPerPage);
		if (categoryId == 0) {
			return productRepo.findAll(pageable);
		}
		return productRepo.findByCategory(categoryId, pageable);
	}
	
	public Product getProductBySlug(String slug) {
		return productRepo.findBySlug(slug);
	}


}
