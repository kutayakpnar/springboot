package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.*;

@Repository
public class AppDAOImp implements AppDAO{

    private EntityManager entityManager;


    @Autowired
    public AppDAOImp(EntityManager entityManager) {
        this.entityManager=entityManager;

    }

    @Override
    @Transactional
    public void save(Instructor instructor) {

        entityManager.persist(instructor);

    }

    @Override
    @Transactional
    public Instructor findInstructorById(int id){
        return entityManager.find(Instructor.class,id);

    }


    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor tempInstructor=findInstructorById(id);
        System.out.println("Deleted instructor:" + tempInstructor.toString());

        List<Course> courses= tempInstructor.getCourses();
        for(Course c: courses){
            c.setInstructor(null);
        }

        entityManager.remove(tempInstructor);
    }

    @Override
    @Transactional
    public InstructorDetail findInstructorDetailById(int id) {
        InstructorDetail detail=entityManager.find(InstructorDetail.class,id);
        System.out.println("detail:" + detail.toString());
        System.out.println("instructor related to detail:"+ detail.getInstructor().toString());
        return detail;

    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {

        InstructorDetail detail= findInstructorDetailById(id);
        System.out.println("deleted detail:" + detail.toString());
        System.out.println("deleted instructor related to detail:"+ detail.getInstructor().toString());

        detail.getInstructor().setInstructorDetail(null);

        entityManager.remove(detail);

    }

    @Override
    @Transactional
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query=entityManager.createQuery("from Course where instructor.id = :data",Course.class);

        query.setParameter("data", id);
        List<Course> courses=query.getResultList();

        return courses;




    }


    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query= entityManager.createQuery(
                "select i from Instructor i "
                        +"JOIN FETCH i.courses "
                        +"JOIN FETCH i.instructorDetail "
                    +"where i.id= :data",Instructor.class);

        query.setParameter("data",id);

        Instructor instructor=query.getSingleResult();

        return  instructor;


    }

    @Override
    @Transactional
    public void update(Instructor instructor) {

        entityManager.merge(instructor);


    }


    @Override
    @Transactional
    public Course findCourseById(int id) {
        return entityManager.find(Course.class,id);

    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);

    }


    @Override
    @Transactional
    public void deleteCourse(int id) {

        Course course=entityManager.find(Course.class,id);

        entityManager.remove(course);

    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);

    }

    @Override
    @Transactional
    public Course findCourseAndReviewsByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select s from Course s "+
                "JOIN FETCH s.reviews "+
                "where s.id = :data",Course.class);

    query.setParameter("data",id);
    return query.getSingleResult();


    }


    @Override
    @Transactional
    public Course findCourseAndStudentByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select s from Course s "+
                "JOIN FETCH s.students "+
                "where s.id = :data",Course.class);

        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public Student findStudentAndCourseByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s "+
                "JOIN FETCH s.courses "+
                "where s.id = :data",Student.class);

        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {

        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student=entityManager.find(Student.class,id);

        entityManager.remove(student);


    }
}
