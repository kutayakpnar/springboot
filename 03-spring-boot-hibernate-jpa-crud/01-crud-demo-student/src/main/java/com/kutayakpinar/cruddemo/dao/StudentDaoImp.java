package com.kutayakpinar.cruddemo.dao;

import com.kutayakpinar.cruddemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao{

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImp(EntityManager entityManager){
        this.entityManager=entityManager;

    }


    @Override
    @Transactional
    public void saveStudent(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    @Transactional
    public Student findStudentById(Integer id) {
        return entityManager.find(Student.class,id);

    }

    @Override
    @Transactional
    public List<Student> findAllStudents() {
        TypedQuery<Student> theQuery= entityManager.createQuery("SELECT s FROM Student s ", Student.class);
        return theQuery.getResultList();

    }

    @Override
    @Transactional
    public List<Student> findStudentByName(String theFirstName) {
        TypedQuery<Student> theQuery= entityManager.createQuery("SELECT s FROM Student s WHERE firstName=:theData ", Student.class);
        theQuery.setParameter("theData",theFirstName);
        return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
       entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        Student student=entityManager.find(Student.class,id);
        entityManager.remove(student);


    }


}
