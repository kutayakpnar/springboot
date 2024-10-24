package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public Employee findEmployeeById(int id) {

        Optional<Employee> employeeOptional= employeeRepository.findById(id);
        Employee employee =null;
        if(employeeOptional.isPresent()){
            employee=employeeOptional.get();
            return  employee;

        }else {
            return null;

        }

    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee) ;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
