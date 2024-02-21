package com.example.Spring.interviewPreparation.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring.interviewPreparation.entity.StudentEntity;
import com.example.Spring.interviewPreparation.exceptions.ErrorResponse;
import com.example.Spring.interviewPreparation.exceptions.StudentNotFoundException;
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
	 
	 @GetMapping("/allStudents")
	 public List<Student> GetAllStudents() {
	 
	 // Save the entity using the service
	 List<Student> savedStudent = studentService.getAllStudents();

	 return savedStudent;
	}
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Object> getStudent(@PathVariable("id") int id) throws StudentNotFoundException {
	     // Your service logic
	     // If StudentNotFoundException occurs, it will be handled by the global exception handler
	     Student student = studentService.getStudent(id);
	     return ResponseEntity.ok(student);
	 }

	 @PutMapping("/update")
	 public String UpdateStudent(@RequestBody Student student) throws StudentNotFoundException {
		// Validate or process the data before saving it (if needed)

		 // Map Student to StudentEntity using ModelMapper
		 StudentEntity studentEntity = modelMapper.map(student, StudentEntity.class);

		 // Save the entity using the service
		 String updatedStudentEntity = studentService.updateStudent(studentEntity);

		 return updatedStudentEntity; 
	 }
	 
}

