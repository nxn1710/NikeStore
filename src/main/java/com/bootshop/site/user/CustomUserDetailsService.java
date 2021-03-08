package com.bootshop.site.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bootshop.site.entities.User;
import com.bootshop.site.repositories.UserRespository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRespository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.getUserByEmail(email);
		if (user != null) {
			return new CustomUserDetails(user);
		}
		return null;
	}

}
