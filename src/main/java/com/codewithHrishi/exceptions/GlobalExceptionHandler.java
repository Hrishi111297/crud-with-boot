package com.codewithHrishi.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codewithHrishi.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ResourceNotFound.class)
ResponseEntity<ApiResponse>resourcenotFound(ResourceNotFound ex){
	ApiResponse a=new ApiResponse(ex.getMessage(),false);
	return new  ResponseEntity<ApiResponse>(a,HttpStatus.NOT_FOUND);
}

@ExceptionHandler(MethodArgumentNotValidException.class)
ResponseEntity<Map<String ,String>>methodArgument(MethodArgumentNotValidException ex){
	Map<String ,String>message=new HashMap<>();
	ex.getBindingResult().getAllErrors().forEach(err->{
String fieldName=((FieldError)err).getField();
String errorMessgae=err.getDefaultMessage();
message.putIfAbsent(fieldName, errorMessgae);
	});
	return  new  ResponseEntity<Map<String,String>>(message,HttpStatus.BAD_REQUEST);
}
}