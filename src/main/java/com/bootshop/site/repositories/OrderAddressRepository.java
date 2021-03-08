package com.bootshop.site.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootshop.site.entities.OrderAddress;
@Repository
public interface OrderAddressRepository extends CrudRepository<OrderAddress, Integer> {

}
