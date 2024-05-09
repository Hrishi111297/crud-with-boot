package com.codewithHrishi;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class StudentBookApplication implements CommandLineRunner{
@Autowired
PasswordEncoder encode;
	public static void main(String[] args) {
		SpringApplication.run(StudentBookApplication.class, args);
	}
	
	@Bean
	ModelMapper modelmapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
System.out.println(encode.encode("abc"));
		
	}

}
