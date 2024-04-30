package com.codewithHrishi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codewithHrishi.entities.Student;
import com.codewithHrishi.exceptions.ResourceNotFound;
import com.codewithHrishi.payloads.StudentDto;
import com.codewithHrishi.payloads.StudentResponse;
import com.codewithHrishi.repositories.StudentRepo;
import com.codewithHrishi.service.Studentservice;

@Service
public class StudentServiceImpl implements Studentservice{
	@Autowired
	ModelMapper convert;
	@Autowired
	StudentRepo repo;
		@Override
		public StudentDto createStudent(StudentDto st) {
	 Student s=this.convert.map(st, Student.class);
			return this.convert.map( this.repo.save(s), StudentDto.class);
		}

		@Override
		public StudentDto updateStudent(StudentDto st,int id) {
	Student s=this.repo.findById(id).orElseThrow(()->new ResourceNotFound("Student", "StudentId", id));
			s.setName(st.getName());s.setEmail(st.getEmail());
			s.setContact(st.getContact());
			s.setUsername(st.getUsername());
			s.setPassword(st.getPassword());
						return this.convert.map( this.repo.save(s), StudentDto.class);
		}

		@Override
		public List<StudentDto> getAllStudents() {
	 List<StudentDto>list=this.repo.findAll().stream().map(s->convert.map(s, StudentDto.class)).collect(Collectors.toList());
			return list;
		}

		@Override
		public StudentDto getPerticularStudent(int id) {
			Student s=this.repo.findById(id).orElseThrow(()->new ResourceNotFound("Student", "StudentId", id));
			return this.convert.map(s, StudentDto.class);
		}

		@Override
		public void deleteStudengt(int id) {
			Student s=this.repo.findById(id).orElseThrow(()->new ResourceNotFound("Student", "StudentId", id));
			this.repo.delete(s);
		}

		@Override
		public StudentResponse getAllStudentswithPagination(int pageSize, int pageNum, String sortBy, String sorDir) {
	Sort s=null;
	s=sorDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
	PageRequest p= PageRequest.of(pageNum, pageSize, s);
	Page<Student>list=this.repo.findAll(p);
	List<StudentDto>list1=list.getContent().stream().map(st->convert.map(st, StudentDto.class)).collect(Collectors.toList());
		StudentResponse sw= new StudentResponse(list1,list.getNumber(),list.getSize(),list.getNumberOfElements(),list.isLast());
	return sw;
		}
}
