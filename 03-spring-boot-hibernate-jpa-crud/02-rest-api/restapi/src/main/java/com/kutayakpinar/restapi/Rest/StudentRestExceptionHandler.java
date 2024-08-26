package com.kutayakpinar.restapi.Rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse response=new StudentErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exc.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleExceptionNew(Exception exc){
        StudentErrorResponse response=new StudentErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage("bad request error");
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

    }
}
