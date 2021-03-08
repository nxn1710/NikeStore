package com.bootshop.site.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootshop.site.entities.Color;
import com.bootshop.site.repositories.ColorRespository;

@Service
public class ColorService {

	@Autowired
	private ColorRespository colorRespository;
	
	public List<Color> getAllColor() {
		return (List<Color>) colorRespository.findAll();
	}
}
