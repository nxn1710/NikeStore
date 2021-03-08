package com.bootshop.site.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootshop.site.entities.Style;
import com.bootshop.site.repositories.StyleRepository;

@Service
public class StyleService {

	@Autowired
	private StyleRepository styleRepository;
	
	public List<Style> getAllStyle() {
		return (List<Style>) styleRepository.findAll();
	}
}
