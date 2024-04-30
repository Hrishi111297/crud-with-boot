package com.codewithHrishi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithHrishi.payloads.ApiResponse;
import com.codewithHrishi.payloads.StudentDto;
import com.codewithHrishi.payloads.StudentResponse;
import com.codewithHrishi.service.Studentservice;
import com.codewithHrishi.util.Appconstant;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
Studentservice serv;
//	@PostMapping("/")
//	ResponseEntity<StudentDto>createStudent(@Valid @RequestBody StudentDto s){
//		return new ResponseEntity<StudentDto>(this.serv.createStudent(s),HttpStatus.CREATED);
//	}
	@PostMapping("/create")
	public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto s) {
	    return new ResponseEntity<>(this.serv.createStudent(s), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	ResponseEntity<List<StudentDto>>getAllStudent(){
		return new ResponseEntity<List<StudentDto>>(this.serv.getAllStudents(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	ResponseEntity<StudentDto> getPerticularStudent(@PathVariable("id")Integer id){
		return new ResponseEntity<StudentDto>(this.serv.getPerticularStudent(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<StudentDto>updateStudent(@Valid @RequestBody StudentDto s,@PathVariable("id")Integer id){
		return new ResponseEntity<StudentDto>(this.serv.updateStudent(s,id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?>deleteStudent(@PathVariable("id")Integer id){
		this.serv.deleteStudengt(id);
		return new ResponseEntity<>(new ApiResponse("Resource deleted successfully",true),HttpStatus.OK);
	}
	@GetMapping("/page/")
	ResponseEntity<StudentResponse>getAllStudentPageWise(@RequestParam(value="pageNum",defaultValue=Appconstant.PAGENUMBER,required=false)Integer pageNum,
			@RequestParam(value="pageSize",defaultValue=Appconstant.PAGESIZE,required=false)Integer pageSize,
			@RequestParam(value="sortBy",defaultValue=Appconstant.SORTBY,required=false)String sortBy 
			,@RequestParam(value="sortDir",defaultValue=Appconstant.SORDIR,required=false)String sortDir){

		return new ResponseEntity<StudentResponse>(this.serv.getAllStudentswithPagination(pageSize,pageNum,sortBy,sortDir),HttpStatus.OK);
	}
	

}
