package com.codewithHrishi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//    	 registry.addMapping("/**")
//         .allowedOrigins("*") // Allow all origins
//         .allowedMethods("*") // Allow all methods (GET, POST, PUT, DELETE, etc.)
//         .allowedHeaders("*"); // Allow all headers
//    }
}