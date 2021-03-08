package com.bootshop.site.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootshop.site.entities.Brand;
import com.bootshop.site.repositories.BrandRespository;

@Service
public class BrandService {

	@Autowired
	private BrandRespository brandRespository;
	
	public List<Brand> getAllBrand() {
		return (List<Brand>) brandRespository.findAll();
	}
}
