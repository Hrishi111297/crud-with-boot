package com.codewithHrishi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.codewithHrishi.entities.Student;
import com.codewithHrishi.exceptions.ResourceNotFound;
import com.codewithHrishi.repositories.StudentRepo;

public class CustomUserDetailService1 implements UserDetailsService{
@Autowired
StudentRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	//loading userfrom Database
	Student s=	repo.findByUsername(username).orElseThrow(()->new ResourceNotFound("Student", "username"+username, 0));
		return null;
	}

}
