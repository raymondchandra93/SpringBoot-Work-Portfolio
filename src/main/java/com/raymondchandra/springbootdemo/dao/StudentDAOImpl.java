package com.raymondchandra.springbootdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raymondchandra.springbootdemo.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

// #1 Method to connect with JPA -> Using Entity Manager

@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl (EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional								// To make this as Transaction
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// Write the query
		// The SELECT statement could be optional 
		// If you use SELECT, it needs to be initial/alias of the table, not *
		TypedQuery<Student> theQuery = entityManager
				.createQuery("SELECT s FROM Student s ORDER BY s.lastName", Student.class);
		
		// Return all of the results
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		// Write the query
		TypedQuery<Student> theQuery = entityManager
				.createQuery("SELECT s FROM Student s WHERE s.lastName=:theData", Student.class);
		
		// Set the parameter
		theQuery.setParameter("theData", lastName);
		
		// Return all of the results
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public int updateLastName(String lastName) {
		// Write the query
		Query theQuery = entityManager
				.createQuery("UPDATE Student SET lastName=:theData WHERE lastName='Doe'");
		
		// Set the parameter
		theQuery.setParameter("theData", lastName);
		
		// Return the number of rows affected
		int numRowsUpdated = theQuery.executeUpdate();
		return numRowsUpdated;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// find the student
		Student student = entityManager.find(Student.class, id);
		
		// delete the student
		entityManager.remove(student);
	}

	@Override
	@Transactional
	public int deleteAll() {
		// Write the query
		Query theQuery = entityManager
				.createQuery("DELETE FROM Student");
		
		// Return the number of rows affected
		int numRowsUpdated = theQuery.executeUpdate();
		return numRowsUpdated;
	}

}
