package com.raymondchandra.springbootdemo;

import java.util.Iterator;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.raymondchandra.springbootdemo.dao.StudentDAO;
import com.raymondchandra.springbootdemo.model.Student;

@SpringBootApplication(
		scanBasePackages= {
			"com.raymondchandra.springbootdemo"
		}
)
public class MydemoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MydemoappApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			System.out.println("Welcome to Raymond's Sprint Boot Demo");

//			// Create a new student
//			createStudent(studentDAO);
//			
//			// Create multiple students
//			createMultipleStudents(studentDAO);

//			// Read a student
//			readStudent(studentDAO);

//			// Read all students
//			readAllStudents(studentDAO);
//
//			// Read all students
//			readStudentsByLastName(studentDAO);
			
//			// Update a student
//			updateStudent(studentDAO);

//			// Update student LastName
//			updateStudentLastName(studentDAO);

//			// Delete a student
//			deleteStudent(studentDAO);
			
//			// Delete all students
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {		
		System.out.println("Deleting student with ID 1");
		studentDAO.delete(1);
		
		System.out.println("Delete is successful");
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsUpdated = studentDAO.deleteAll();
		
		System.out.println("Number of rows affected: " + numRowsUpdated);
		
	}

	private void updateStudentLastName(StudentDAO studentDAO) {
		System.out.println("Updating student's LastName to Doeee");
		int numRowsUpdated = studentDAO.updateLastName("Doeee");
		
		System.out.println("Reading the updated student object");
		List<Student> students = studentDAO.findByLastName("Doeee");
		
		for (Student student : students) {			
			System.out.println("The student is: " + student);
		}

		System.out.println("Number of rows affected: " + numRowsUpdated);
	}

	private void updateStudent(StudentDAO studentDAO) {
		System.out.println("Reading a student object");
		Student student = studentDAO.findById(1);
		
		System.out.println("Updating student's FirstName to Scobby");
		student.setFirstName("Scobby");
		studentDAO.update(student);
		
		System.out.println("Reading the updated student object");
		student = studentDAO.findById(1);

		System.out.println("The new student is: " + student);
		
	}

	private void readStudentsByLastName(StudentDAO studentDAO) {
		System.out.println("Reading student objects based on last name");
		List<Student> students = studentDAO.findByLastName("Doe");
		
		for (Student student : students) {			
			System.out.println("The student is: " + student);
		}
	}

	private void readAllStudents(StudentDAO studentDAO) {
		System.out.println("Reading all student objects");
		List<Student> students = studentDAO.findAll();
		
		for (Student student : students) {			
			System.out.println("The student is: " + student);
		}
		
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Reading a new student object");
		Student student = studentDAO.findById(1);
		
		System.out.println("The student is: " + student);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 new student objects");
		Student student1 = new Student("John", "Doe", "johnd@email.com");
		Student student2 = new Student("Jane", "Doe", "janed@email.com");
		Student student3 = new Student("Bonita", "Applebum", "bonitaa@email.com");
		
		System.out.println("Saving the students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		
		System.out.println("The new student 1 ID is: " + student1.getId());
		System.out.println("The new student 2 ID is: " + student2.getId());
		System.out.println("The new student 3 ID is: " + student3.getId());
		// TODO Auto-generated method stub
		
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new student object");
		Student student = new Student("Foo", "Bar", "foobar@email.com");
		
		System.out.println("Saving the student");
		studentDAO.save(student);
		
		System.out.println("The new student ID is: " + student.getId());
	}

}
