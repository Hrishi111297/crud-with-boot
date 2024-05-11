
package com.codewithHrishi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.codewithHrishi.security.CustomUserDetailService1;

@Configuration
public class AppConfig { 
	// step 4
//this is for without data base
//	@Bean
//	public UserDetailsService userDetailService() {
//		UserDetails ayush = User.builder().username("HM1594").password(passwordEncoder().encode("abc")).roles("ADMIN")
//				.build();
//		UserDetails hrishi = User.builder().username("hrishi").password(passwordEncoder().encode("abc")).roles("ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(ayush, hrishi);
//	} 
	
	
	
	// @Bean // public PasswordEncoder passwordEncoder() {O // // For
//	simplicity,
//
//	using NoOpPasswordEncoder
//	which treats
//	passwords as
//	plain text //
//	return NoOpPasswordEncoder.getInstance(); // }
	
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	 @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
	        return builder.getAuthenticationManager();
	    }

//	json Web
//	Token it
//	used to claim true
//	between two
//	parties It
//	consist of
//	three
//  parts
//	x.y.z x->
//	token typeand
//	algorithm hs256
//	and y->PayLoad->data represent z->Verify signature->header and
//	payload and
//	secret key
//	all are
//	in encrypted
//	format client
//	cannot access
//	the apis
//	directly
//  
//  
//  first
//	authentication of
//	the username
//	and password
//	and then return
//	jwt token while
//	requesting it
//	will send
//	an jwt
//	token from
//	client to
//	the server
//	at the
//	server it
//	will validate
//	token and
//	then retuen
//	the response
//
//	jwt api&
//	jwt api
//	jwt jackson
	 
	 @Autowired
	 CustomUserDetailService1 userDetailService1;
	 //for the database authentication
	 @Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailService1);
		daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
		return daoAuthenticationProvider;
	}

}
