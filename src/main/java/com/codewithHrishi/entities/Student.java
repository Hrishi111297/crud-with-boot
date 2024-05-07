package com.codewithHrishi.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student  {
	//second step of Security we cant directly return username so we are returning the processed student object
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@Column(name="student_name")
private String name;
	@Column(name="student_email")
private String email;
	@Column(name="number")
private long contact;
	
private String username;

private String password;


}
