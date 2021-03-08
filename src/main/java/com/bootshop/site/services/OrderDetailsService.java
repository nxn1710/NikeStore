package com.bootshop.site.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootshop.site.entities.Order;
import com.bootshop.site.entities.OrderDetails;
import com.bootshop.site.repositories.OrderDetailsRepository;
import com.bootshop.site.repositories.OrderRepository;
@Service
public class OrderDetailsService  {

	@Autowired
	private OrderDetailsRepository orderDetailsRepo;
	
	public void save(OrderDetails order) {
		orderDetailsRepo.save(order);
	}

}
