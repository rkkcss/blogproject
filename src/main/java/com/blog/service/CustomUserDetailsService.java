package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.blog.entity.Blogger;
import com.blog.repository.BloggerRepo;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private BloggerRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Blogger blogger = repo.findByName(username);
		if (blogger == null) {
			throw new UsernameNotFoundException("Username not found.");
		}
		return new CustomUserDetails(blogger);
	}

}
