package com.bootshop.site.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootshop.site.entities.User;

@Repository
public interface UserRespository extends CrudRepository<User, Integer>{
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User getUserByEmail(String email);
}
