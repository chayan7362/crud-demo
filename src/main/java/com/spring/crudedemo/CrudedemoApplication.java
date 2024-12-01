package com.spring.crudedemo;

import com.spring.crudedemo.dao.StudentDAO;
import com.spring.crudedemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudedemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
//			createStudent(studentDAO);

			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsBylastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudent(studentDAO);

		};

	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all Students.....");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count :"+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 2;
		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve Student based on ID : Primary key
		int studentId = 1;
		System.out.println("Getting Student with iD: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		// Change First Name to "DonChayan"
		System.out.println("Updating student ........");
		myStudent.setFirstName("DonChayan");

		// Update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student : "+ myStudent);
	}

	private void queryForStudentsBylastName(StudentDAO studentDAO) {
		// get a list of Students
		List<Student> slist = studentDAO.findBylastName("Maji");

		// Display list of Students
		for(Student s : slist){
			System.out.println(s);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Get list of Students
		List<Student> sList = studentDAO.findAll();

		// Display List of Students
		for (Student tempStudent : sList){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create a Student object
		System.out.println("Creating the 3 Student object...");
		Student s1 = new Student("Chayan","Maiti","chayanmaiti2017@gmail.com");

		// Save the Student
		System.out.println("Save the student.......");
		studentDAO.save(s1);

		// Display Id of the save Student
		int tempId =  s1.getId();
		System.out.println("Save the Student. Generated id : "+tempId);

		// Retrieve student based on ID: Primary Key
		System.out.println("Retrieve Student based with Id :"+tempId);
		Student myStudent = studentDAO.findById(tempId);

		// Display the student
		System.out.println(myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating the 3 Student object...");
		Student s1 = new Student("Chayan","Maiti","chayanmaiti2017@gmail.com");
		Student s2 = new Student("Surajit","Dutta","surajit123@gmail.com");
		Student s3 = new Student("Romit","Maji","ramitmaji123@gmail.com");

		// save the students object.....
		System.out.println("Save the student.......");
		studentDAO.save(s1);
		studentDAO.save(s2);
		studentDAO.save(s3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// Create the Student object
		System.out.println("Creating the Student object...");
		Student s1 = new Student("Chayan","Maiti","chayanmaiti2017@gmail.com");

		// save the student object
		System.out.println("Save the student.......");
		studentDAO.save(s1);

		//display id of the save student
		System.out.println("Save Student . Generated Id: "+s1.getId());

	}

}
