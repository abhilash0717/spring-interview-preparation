package com.example.Spring.interviewPreparation.repository;

import org.springframework.stereotype.Repository;

import com.example.Spring.interviewPreparation.entity.StudentEntity;
import com.example.Spring.interviewPreparation.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
	
	@PersistenceContext
    private EntityManager entityManager;

	@Transactional
	@Override
	public String saveStudent(StudentEntity student) {
		
		entityManager.persist(student);
		
		return "Student saved successfully!";
	}
}
