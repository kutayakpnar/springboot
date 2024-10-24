package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findEmployeeById(int id);

    Employee save(Employee employee);

    void deleteById(int id);



}
