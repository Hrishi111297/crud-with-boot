package com.codewithHrishi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {
	//step 4
	@Bean
public UserDetailsService userDetailService() {
	UserDetails ayush=  User.builder().username("ayush").password(passwordEncoder().encode("abc")).roles("ADMIN").build();
	UserDetails hrishi=  User.builder().username("hrishi").password(passwordEncoder().encode("abc")).roles("ADMIN").build();
	return new InMemoryUserDetailsManager(ayush,hrishi);
			}
//	 @Bean
//	    public PasswordEncoder passwordEncoder() {O
//	        // For simplicity, using NoOpPasswordEncoder which treats passwords as plain text
//	        return NoOpPasswordEncoder.getInstance();
//	    }
	 @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/*
	 * json Web Token
	 * it used to claim true between two parties
	 * It consist of three parts 
	 * x.y.z
	 * x-> token typeand algorithm hs256 and 
	 * y->PayLoad ->data represent 
	 * z->Verify signature ->header and payload and secret key  all are in encrypted format
	 * client cannot access the apis directly
	 * 
	 * 
	 * first authentication of the username and password and then return jwt token 
	 * while requesting it will send an jwt token from client to the server at the server it will validate token and then retuen the response
	 * 
	 * 
	 * jwt api & jwt api
	 * jwt jackson
	 * 
	*/
}