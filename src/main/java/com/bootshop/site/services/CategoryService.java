package com.bootshop.site.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootshop.site.entities.Category;
import com.bootshop.site.entities.Size;
import com.bootshop.site.repositories.CategoryRespository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRespository categoryRespository;
	
	public List<Category> getAllCategory() {
		return (List<Category>) categoryRespository.findAll();
	}
}
