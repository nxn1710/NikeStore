package com.bootshop.site.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootshop.site.entities.Size;

@Repository
public interface SizeRespository extends CrudRepository<Size, Integer>{

}
