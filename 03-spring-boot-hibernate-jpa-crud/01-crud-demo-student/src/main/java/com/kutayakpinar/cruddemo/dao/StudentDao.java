package com.kutayakpinar.cruddemo.dao;

import com.kutayakpinar.cruddemo.Entity.Student;

import java.util.List;

public interface StudentDao {

    public void saveStudent(Student theStudent);

    public Student findStudentById(Integer id);

    public List<Student> findAllStudents();


    public List<Student> findStudentByName(String theFirstName);

    public void updateStudent(Student theStudent);

    public void deleteStudent(Integer id);




}
