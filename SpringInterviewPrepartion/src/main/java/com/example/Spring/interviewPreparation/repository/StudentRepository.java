package com.example.Spring.interviewPreparation.repository;

import com.example.Spring.interviewPreparation.entity.StudentEntity;
import com.example.Spring.interviewPreparation.model.Student;

public interface StudentRepository {
	public String saveStudent(StudentEntity student);
}
