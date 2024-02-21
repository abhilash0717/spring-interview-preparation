package com.example.Spring.interviewPreparation.repository;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Spring.interviewPreparation.entity.StudentEntity;
import com.example.Spring.interviewPreparation.exceptions.StudentNotFoundException;
import com.example.Spring.interviewPreparation.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	@Override
	public String saveStudent(StudentEntity student) {
		
		entityManager.persist(student);
		
		return "Student saved successfully!";
	}

	@Override
	public List<Student> getAllStudents() {
		
		// Use JPQL to query all students from the database
		//spring data jpa implementation is easy.. try to refer that when u practice spring data jpa
        String jpql = "SELECT s FROM StudentEntity s";
        List<StudentEntity> studentsEntities =  entityManager.createQuery(jpql, StudentEntity.class).getResultList();
        
        List<Student> students = new ArrayList<>();
        
        for(StudentEntity studentEntity : studentsEntities) {
        	students.add(modelMapper.map(studentEntity, Student.class));
        }
        
        return students;
	}

	@Override
	public Student getStudent(int id) throws StudentNotFoundException {
	    StudentEntity studentEntity = entityManager.find(StudentEntity.class, id);

	    if (studentEntity != null) {
	        return modelMapper.map(studentEntity, Student.class);
	    } else {
	        // Handle the case where the student is not found
	        // For example, throw a custom exception, return a default student, or log the issue
	        throw new StudentNotFoundException("Student with ID " + id + " not found");
	    }
	}
	
	@Transactional
	@Override
	public String updateStudent(StudentEntity studentEntity) throws StudentNotFoundException {
		Student SearchedStudent = getStudent(studentEntity.getId());
		
		if (SearchedStudent != null) {
			
			StudentEntity currEntity = new StudentEntity();
			currEntity.setEmail(studentEntity.getEmail());
			currEntity.setFirstName(studentEntity.getFirstName());
			currEntity.setLastName(studentEntity.getLastName());
			currEntity.setPhoneNumber(studentEntity.getPhoneNumber());
			
			entityManager.persist(currEntity);
	    } else {
	        // Handle the case where the student is not found
	        // For example, throw a custom exception, return a default student, or log the issue
	        throw new StudentNotFoundException("Student with ID " + SearchedStudent.getId() + " not found");
	    }
		
		return "Student Saved Successfully!";
	}

}
