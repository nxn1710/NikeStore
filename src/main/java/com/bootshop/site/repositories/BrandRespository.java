package com.bootshop.site.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootshop.site.entities.Brand;

@Repository
public interface BrandRespository extends CrudRepository<Brand, Integer>{

}
