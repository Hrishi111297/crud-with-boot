package com.codewithHrishi.service;

import java.util.List;

import com.codewithHrishi.payloads.StudentDto;
import com.codewithHrishi.payloads.StudentResponse;

public interface Studentservice {
	public StudentDto createStudent(StudentDto s);
	public StudentDto updateStudent(StudentDto s, int id);
	public List<StudentDto> getAllStudents();
	public StudentDto getPerticularStudent(int id);
	public void deleteStudengt(int id);
	public StudentResponse getAllStudentswithPagination(int pageSize,int pageNum,String sortBy,String sorDir);
}
