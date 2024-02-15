package com.example.Spring.interviewPreparation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Spring.interviewPreparation.entity.StudentEntity;
import com.example.Spring.interviewPreparation.model.Student;
import com.example.Spring.interviewPreparation.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public String saveStudent(StudentEntity student) {
		// TODO Auto-generated method stub
		return studentRepository.saveStudent(student);
	}

}
