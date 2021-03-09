package com.bootshop.site.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootshop.site.entities.Category;

@Repository
public interface CategoryRespository extends CrudRepository<Category, Integer>{

}
