package com.example.Spring.interviewPreparation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Spring.interviewPreparation.entity.StudentEntity;
import com.example.Spring.interviewPreparation.exceptions.StudentNotFoundException;
import com.example.Spring.interviewPreparation.model.Student;
import com.example.Spring.interviewPreparation.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public String saveStudent(StudentEntity student) {
		
		return studentRepository.saveStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.getAllStudents();
	}

	@Override
	public Student getStudent(int id) throws StudentNotFoundException {
		
		return studentRepository.getStudent(id);
	}

	@Override
	public String updateStudent(StudentEntity studentEntity) throws StudentNotFoundException {
		
		return studentRepository.updateStudent(studentEntity);
	}

}
