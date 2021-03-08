package com.bootshop.site.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootshop.site.entities.Style;

@Repository
public interface StyleRepository extends CrudRepository<Style, Integer>{

}
