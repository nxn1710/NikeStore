package com.bootshop.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootshop.site.entities.User;
import com.bootshop.site.repositories.UserRespository;

@Service
public class UserService {

	@Autowired
	private UserRespository userRepo;
	
	public User getByEmail(String email) {
		return userRepo.getUserByEmail(email);
	}
	
	public User save(User u) {
		return userRepo.save(u);
	}

	public boolean isEmailUnique(String email) {
		return userRepo.getUserByEmail(email) == null;
	}
}
