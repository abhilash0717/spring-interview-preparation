package com.example.Spring.interviewPreparation.repository;

import java.util.List;

import com.example.Spring.interviewPreparation.entity.StudentEntity;
import com.example.Spring.interviewPreparation.exceptions.StudentNotFoundException;
import com.example.Spring.interviewPreparation.model.Student;

public interface StudentRepository {
	public String saveStudent(StudentEntity student);
	public List<Student> getAllStudents();
	public Student getStudent(int id) throws StudentNotFoundException;
	public String updateStudent(StudentEntity studentEntity) throws StudentNotFoundException;
}
