package com.bootshop.site.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootshop.site.entities.Color;

@Repository
public interface ColorRespository extends CrudRepository<Color, Integer>{

}
