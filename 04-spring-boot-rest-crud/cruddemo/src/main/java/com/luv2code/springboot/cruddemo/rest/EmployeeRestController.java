package com.luv2code.springboot.cruddemo.rest;



import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
     public List<Employee> findAll() {

        return employeeService.findAll();


     }

     @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.findEmployeeById(id);

     }

     @DeleteMapping("/employees/{id}")
    public void deleteEmpById(@PathVariable int id){
        employeeService.deleteById(id);

     }

     @PostMapping("/add")
    public Employee addEmp(@RequestBody Employee employee){
        return employeeService.save(employee);

     }

     @PutMapping("/update")
    public Employee update(@RequestBody Employee employee){

        Employee employeedb=employeeService.save(employee);
        return employeedb;


     }

}
