package com.kutayakpinar.springcoredemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    private ICoach mycoach;

    @Autowired
    public DemoController(TennisCoach coach){
        this.mycoach=coach;


    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
       return mycoach.getDailyWorkout();

    }


}
