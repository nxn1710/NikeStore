package com.bootshop.site.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootshop.site.entities.ProductsSizes;

@Repository
public interface ProductsSizesRepository extends CrudRepository<ProductsSizes, Integer>{

}
