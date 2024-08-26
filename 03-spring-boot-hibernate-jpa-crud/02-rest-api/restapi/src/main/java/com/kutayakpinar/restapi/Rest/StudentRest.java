package com.kutayakpinar.restapi.Rest;


import com.kutayakpinar.restapi.Entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRest {


    List<Student> studentArr;

    @PostConstruct
    public void loadData(){
        studentArr= new ArrayList<>();
        studentArr.add(new Student("Kutay","Akpinar"));
        studentArr.add(new Student("Ali","Kiymaz"));
        studentArr.add(new Student("Alican","Ertekin"));

    }


    @GetMapping("/students")
    public List<Student> getStudents(){


        return studentArr;


    }

    @GetMapping("/students/{studentid}")
    public Student getStudentById(@PathVariable Integer studentid){

        if((studentArr.size()<=studentid) || studentid<0){
            throw new StudentNotFoundException("Student id not found" + studentid);
        }
        return studentArr.get(studentid);
    }


}
