package com.kutayakpinar.springcoredemo.rest;


import com.kutayakpinar.springcoredemo.common.ICoach;
import com.kutayakpinar.springcoredemo.common.SwimCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    private ICoach mycoach;
    //private ICoach anotherCoach;

    @Autowired
    public void DemoController(@Qualifier("aquatic") ICoach coach){
        System.out.println(getClass().getSimpleName());
        this.mycoach=coach;
        //this.anotherCoach=anotherCoach;



    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
       return mycoach.getDailyWorkout();

    }

    /*
    @GetMapping("/check")
    public String checkBean(){
        return "comparing beans:" + (this.mycoach.equals(this.anotherCoach));

    }
    */



}
