package com.bootshop.site.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootshop.site.entities.Product;
import com.bootshop.site.entities.ProductsSizes;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{
	@Query("SELECT p FROM Product p WHERE p.slug = ?1")
	public Product findBySlug(String slug);
	
	public Long countById(@Param("id") Integer id);

	
	@Query("SELECT p FROM Product p WHERE p.category.id = ?1")
	public Page<Product> findByCategory(Integer categoryId, Pageable pageable);
	
	@Query(value="SELECT TOP 8 * FROM Product ORDER BY edit_time DESC", nativeQuery = true)
	public List<Product> getNewProduct();
	
	@Query("SELECT p FROM Product p WHERE p.category.id = ?1 AND p.color.id = ?2 AND p.brand.id = ?3 AND p.style.id = ?4")
	public Page<Product> getFindCustomProduct(Integer category, Integer color, Integer brand, Integer style, Pageable pageable);
}
