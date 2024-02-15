package com.example.Spring.interviewPreparation.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring.interviewPreparation.entity.StudentEntity;
import com.example.Spring.interviewPreparation.model.Student;
import com.example.Spring.interviewPreparation.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	 @Autowired
	 private ModelMapper modelMapper;

	 @PostMapping("/save")
	 public String saveStudent(@RequestBody Student student) {
	 // Validate or process the data before saving it (if needed)

	 // Map Student to StudentEntity using ModelMapper
	 StudentEntity studentEntity = modelMapper.map(student, StudentEntity.class);

	 // Save the entity using the service
	 String savedStudentEntity = studentService.saveStudent(studentEntity);

	 return savedStudentEntity;
	}
}
