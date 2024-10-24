package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return args -> {
			//createInstructor(appDAO);

			//findInstructorById(appDAO);

			//deleteInstructorById(appDAO);

			//findInstructorDetailById(appDAO);

			//deleteInstructorDetailById(appDAO);

			//createInstructorWithCourses(appDAO);

			//findInstructorWithCourses(appDAO);

			//findCoursesForInstructor(appDAO);

			//findInstructorWithCoursesJoinFetch(appDAO);

			//updateInstructor(appDAO);


			//updateCourse(appDAO);


			//deleteCourse(appDAO);
			
			//createCourseAndReviews(appDAO);

			//retrieveCourseAndReviews(appDAO);

			//deleteCourseAndReviews(appDAO);

			//createCourseAndStudents(appDAO);
			
			//findCourseAndStudents(appDAO);

			//findStudentAndCourses(appDAO);

			//addMoreCoursesForStudent(appDAO);

			//findStudentAndCourses(appDAO);

			//deleteCourse(appDAO);

			deleteStudent(appDAO);



			


			








		};

	}

	private void deleteStudent(AppDAO appDAO) {

		appDAO.deleteStudent(2);

	}


	private void addMoreCoursesForStudent(AppDAO appDAO) {

		Student student =appDAO.findStudentAndCourseByStudentId(2);

		Course course1 =new Course("course new 1");

		Course course2 =new Course("course new 2");

		Course course3 =new Course("course new 3");

		student.addCourse(course1);
		student.addCourse(course2);
		student.addCourse(course3);

		appDAO.update(student);



	}

	private void findStudentAndCourses(AppDAO appDAO) {

		Student student = appDAO.findStudentAndCourseByStudentId(2);
		System.out.println(student);
		System.out.println(student.getCourses());
		System.out.println("donee!!!!!!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		Course course =appDAO.findCourseAndStudentByCourseId(11);
		System.out.println(course);
		System.out.println(course.getStudents());

		System.out.println("Done!!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course tempCourse=new Course("Course1");
		Student tempStudent1=new Student("kutay","akpinar","kutay@example.com");
		Student tempStudent2=new Student("cagla","akpinar","cagla@example.com");
		Student tempStudent3=new Student("eco","akpinar","eco@example.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving the course:"+ tempCourse);
		System.out.println("Associated students:" + tempCourse.getStudents() );

		appDAO.save(tempCourse);

		System.out.println("Done!");


	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		appDAO.deleteCourse(10);

	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		Course course= appDAO.findCourseAndReviewsByCourseId(10);
		System.out.println(course);
		System.out.println(course.getReviews());


	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course tempCourse=new Course("course1");
		tempCourse.addReview(new Review("comment1"));
		tempCourse.addReview(new Review("comment2"));
		tempCourse.addReview(new Review("comment3"));

		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);




	}

	private void deleteCourse(AppDAO appDAO) {

		appDAO.deleteCourse(14);
	}

	private void updateCourse(AppDAO appDAO) {

		Course course=appDAO.findCourseById(13);
		course.setTitle("asdad");

		appDAO.update(course);


	}

	private void updateInstructor(AppDAO appDAO) {

		Instructor temp = appDAO.findInstructorById(2);
		System.out.println("finding instructor:" +temp.toString());

		temp.setLastName("AKPINAR");
		appDAO.update(temp);
		System.out.println("updated instructor" + temp.toString());



	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		Instructor instructor=appDAO.findInstructorByIdJoinFetch(2);

		System.out.println("instructor:"+ instructor);
		System.out.println("courses related to instructor:"+instructor.getCourses());
		System.out.println("instructor detail:"+ instructor.getInstructorDetail());

		System.out.println("done!!!!!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		Instructor instructor= appDAO.findInstructorById(2);

		List<Course> courses=appDAO.findCoursesByInstructorId(2);

		System.out.println("Instructor:" +instructor.toString());
		instructor.setCourses(courses);

		System.out.println("Associated courses:" + instructor.getCourses());


	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		Instructor instructor= appDAO.findInstructorById(2);


		System.out.println("Instructor:" +instructor.toString());
		System.out.println("Associated courses:" + instructor.getCourses());


	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor=new Instructor("susan","public","x@luv2code.com");

		InstructorDetail instructorDetail =new InstructorDetail("susan.youtube.com","coding");

		tempInstructor.setInstructorDetail(instructorDetail);

		Course tempcourse1= new Course("MATH");
		Course tempcourse2= new Course("BIOLOGY");
		Course tempcourse3= new Course("PHYSIC");
		tempInstructor.add(tempcourse1);
		tempInstructor.add(tempcourse2);
		tempInstructor.add(tempcourse3);

		System.out.println("Saving instructor: "+ tempInstructor.toString());
		System.out.println("the courses:"+ tempInstructor.getCourses());



		appDAO.save(tempInstructor);


	}

	private void createInstructor(AppDAO appDAO){
		Instructor tempInstructor=new Instructor("Chad","Derby","x@luv2code.com");

		InstructorDetail instructorDetail =new InstructorDetail("xx.youtube.com","basketball");

		tempInstructor.setInstructorDetail(instructorDetail);
		appDAO.save(tempInstructor);

	}

	private Instructor findInstructorById(AppDAO appDAO){


		Instructor instructor= appDAO.findInstructorById(3);
		System.out.println(instructor.toString());
		System.out.println(instructor.getInstructorDetail().toString());
		return instructor;



	}

	private void deleteInstructorById(AppDAO appDAO){
		appDAO.deleteInstructorById(2);

	}

	private InstructorDetail findInstructorDetailById(AppDAO appDAO){
		return appDAO.findInstructorDetailById(6);

	}

	private void deleteInstructorDetailById(AppDAO appDAO){
		appDAO.deleteInstructorDetailById(7);
	}




}
