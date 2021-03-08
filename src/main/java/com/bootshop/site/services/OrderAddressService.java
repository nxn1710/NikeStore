package com.bootshop.site.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootshop.site.entities.OrderAddress;
import com.bootshop.site.repositories.OrderAddressRepository;
@Service
public class OrderAddressService  {

	@Autowired
	private OrderAddressRepository addressRepo;
	
	public void save(OrderAddress orderAddress) {
		addressRepo.save(orderAddress);
	}
	
	public OrderAddress getById(Integer id) {
		return addressRepo.findById(id).get();
	}

}
