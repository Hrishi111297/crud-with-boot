package com.codewithHrishi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentBookApplication.class, args);
	}
	
	@Bean
	ModelMapper modelmapper() {
		return new ModelMapper();
	}

}
