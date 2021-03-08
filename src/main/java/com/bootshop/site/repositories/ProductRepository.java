package com.bootshop.site.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootshop.site.entities.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{
	@Query("SELECT p FROM Product p WHERE p.slug = ?1")
	public Product findBySlug(String slug);
	
	public Long countById(@Param("id") Integer id);

	
	@Query("SELECT p FROM Product p WHERE p.category.id = ?1")
	public Page<Product> findByCategory(Integer categoryId, Pageable pageable);
}
