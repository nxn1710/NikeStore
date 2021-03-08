package com.bootshop.site.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootshop.site.entities.Order;
import com.bootshop.site.entities.OrderDetails;
@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer> {

}
