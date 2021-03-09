package com.bootshop.site.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootshop.site.entities.Order;
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
	@Query("SELECT o FROM Order o WHERE o.orderAddress.user.email = ?1 ORDER BY o.time DESC")
	public Page<Order> getOrdersByUser(String email, Pageable pageable);

}
