package com.example.Spring.interviewPreparation.service;


import java.util.List;

import com.example.Spring.interviewPreparation.entity.StudentEntity;
import com.example.Spring.interviewPreparation.exceptions.StudentNotFoundException;
import com.example.Spring.interviewPreparation.model.Student;

public interface StudentService {
	public String saveStudent(StudentEntity studentEntity);
	public List<Student> getAllStudents();
	public Student getStudent(int id) throws StudentNotFoundException;
}
