package com.kutayakpinar.cruddemo;

import com.kutayakpinar.cruddemo.Entity.Student;
import com.kutayakpinar.cruddemo.dao.StudentDao;
import com.kutayakpinar.cruddemo.dao.StudentDaoImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDaoImp studentDao) {
		return runner ->{
			createMultipleStudent(studentDao);
			findStudentById(studentDao,1);
			getAllStudents(studentDao);
			getStudentsByName(studentDao,"Cagla");
			updateStudent(studentDao,2);
			//deleteStudentById(studentDao,3);



			
		};

	}

	public void createMultipleStudent(StudentDaoImp studentDao) {
		System.out.println("Creating multiple student");
		Student tempStudent1=new Student("Kutay","Akpinar2","akpnar2@gmail.com");
		Student tempStudent2=new Student("Cagla","Akpinar2","akpnar2@gmail.com");
		Student tempStudent3=new Student("Ecrin","Akpinar2","akpnar2@gmail.com");
		studentDao.saveStudent(tempStudent1);
		studentDao.saveStudent(tempStudent2);
		studentDao.saveStudent(tempStudent3);
		System.out.println("Saved Student:"+ tempStudent1.toString());
		System.out.println("Saved Student:"+ tempStudent2.toString());
		System.out.println("Saved Student:"+ tempStudent3.toString());


	}

	public void createStudent(StudentDao studentDao) {
		System.out.println("Creating new student object...");
		Student tempStudent=new Student("Kutay2","Akpinar2","akpnar2@gmail.com");
		System.out.println("Saving new student");
		studentDao.saveStudent(tempStudent);
		System.out.println("Saved Student:"+ tempStudent.toString());
	}

	public Student findStudentById(StudentDaoImp studentDaoImp,Integer id){
		System.out.println("Student is finding ");
		System.out.println(studentDaoImp.findStudentById(id).toString());
		return studentDaoImp.findStudentById(id);


	}

	public void getAllStudents(StudentDaoImp studentDaoImp){
		 List<Student> students=studentDaoImp.findAllStudents();
		 for(Student tempStudent:students) {
			System.out.println(tempStudent.toString());
		}
	}

	public void getStudentsByName(StudentDaoImp studentDaoImp,String theFirstname){
		List<Student> students=studentDaoImp.findStudentByName(theFirstname);
		for(Student tempStudent:students) {
			System.out.println(tempStudent.toString());
		}
	}

	public void updateStudent(StudentDaoImp studentDaoImp,Integer id){
		Student student=studentDaoImp.findStudentById(id);
		student.setFirstName("scoobyy");
		System.out.println("Student has been updated.");
		System.out.println(student.toString());
		studentDaoImp.updateStudent(student);



	}

	public void deleteStudentById(StudentDaoImp studentDaoImp,Integer id){
		studentDaoImp.deleteStudent(id);
	}



}
