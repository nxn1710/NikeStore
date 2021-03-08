package com.bootshop.site.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootshop.site.entities.Size;
import com.bootshop.site.repositories.SizeRespository;

@Service
public class SizeService {

	@Autowired
	private SizeRespository sizeRespository;
	
	public List<Size> getAllSize() {
		return (List<Size>) sizeRespository.findAll();
	}
}
