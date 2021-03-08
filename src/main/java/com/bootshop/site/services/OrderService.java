package com.bootshop.site.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootshop.site.entities.Order;
import com.bootshop.site.repositories.OrderRepository;
@Service
public class OrderService  {

	@Autowired
	private OrderRepository orderRepo;
	
	public Order save(Order order) {
		return orderRepo.save(order);
	}
	
	public Order getById(Integer id) {
		Optional<Order> orderOp = orderRepo.findById(id);
		if (orderOp == null) {
			return null;
		};
		return orderOp.get();
	}

	public List<Order> getOrdersByUser(String email) {
		return orderRepo.getOrdersByUser(email);
	}
}
