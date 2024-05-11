package com.codewithHrishi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.codewithHrishi.security.Entrypoint;
import com.codewithHrishi.security.Filter;

@Configuration
@EnableWebMvc
public class SecurityConfig {

	public static final String[] URL_CONST= {"/v3/api-docs",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**","/auth/login"};
    @Autowired
    private Entrypoint point;
    @Autowired
    private Filter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()).cors(cors->cors.disable())
           .authorizeHttpRequests(auth->auth.requestMatchers("/api/student").authenticated().
        		   
        		   requestMatchers(URL_CONST).permitAll().anyRequest().authenticated()).
               exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}