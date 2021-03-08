package com.bootshop.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootshop.site.entities.ProductsSizes;
import com.bootshop.site.repositories.ProductsSizesRepository;

@Service
public class ProductsSizeService {
	@Autowired
	private ProductsSizesRepository productSizeRepo;
	
	public ProductsSizes getById(Integer id) {
		return productSizeRepo.findById(id).get();
	}
}
