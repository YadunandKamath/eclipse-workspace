package com.orm.jpademo;

import com.orm.jpademo.dao.IStudentDAO;
import com.orm.jpademo.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(IStudentDAO studentDAO) {

		return runner -> {
			//createStudent(studentDAO);
			createStudents(studentDAO);
			//readStudent(studentDAO);
			//queryStudents(studentDAO);
			//queryStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void createStudent(IStudentDAO studentDAO) {

		System.out.println("Creating new student object...");
		Student newStudent = new Student("z","c","je@luv2code.com");

		System.out.println("Saving new student object...");
		studentDAO.saveStudent(newStudent);

		System.out.println("New student object saved. Generated ID: " + newStudent.getStudentId());
	}

	private void createStudents(IStudentDAO studentDAO) {

		System.out.println("Creating new student objects...");
		Student student1 = new Student("Paul","Doe","paul@luv2code.com");
		Student student2 = new Student("Jane","Dane","jane@luv2code.com");
		Student student3 = new Student("Kirby","Chad","kirby@luv2code.com");

		System.out.println("Saving new student objects...");

		studentDAO.saveStudent(student1);
		System.out.println("New student object saved. Generated ID: " + student1.getStudentId());
		studentDAO.saveStudent(student2);
		System.out.println("New student object saved. Generated ID: " + student2.getStudentId());
		studentDAO.saveStudent(student3);
		System.out.println("New student object saved. Generated ID: " + student3.getStudentId());

	}

	private void readStudent(IStudentDAO studentDAO) {

		System.out.println("Retrieving data of Student with ID: 2");
		System.out.println(studentDAO.findStudentById(2));
	}

	private void queryStudents(IStudentDAO studentDAO) {

		System.out.println("Querying all students...");
		List<Student> studentList = studentDAO.findAllStudents();

		for (Student s: studentList) {
			System.out.println(s);
		}
	}

	private void queryStudentsByLastName(IStudentDAO studentDAO) {

		System.out.println("Querying students by last name...");
		List<Student> studentList = studentDAO.findStudentsByLastName("Doe");
		for (Student s: studentList) {
			System.out.println(s);
		}
	}

	private void updateStudent(IStudentDAO studentDAO){

		System.out.println("Retrieving data of Student with ID: 3");
		Student getStudent = studentDAO.findStudentById(3);
		System.out.println(getStudent);

		System.out.println("Updating Student data...");
		getStudent.setFirstName("Jack");
		studentDAO.updateStudent(getStudent);

		System.out.println("Updated Student data: ");
		System.out.println(studentDAO.findStudentById(3));
	}

	private void deleteStudent(IStudentDAO studentDAO) {

		System.out.println("Deleting student with ID: 6");

		studentDAO.deleteStudent(6);

		List<Student> studentList = studentDAO.findAllStudents();
		for (Student s: studentList) {
			System.out.println(s);
		}
	}

	private void deleteAllStudents(IStudentDAO studentDAO) {

		System.out.println("Deleting all Students...");
		System.out.println("Rows Deleted: " + studentDAO.deleteAllStudents());
	}
}
