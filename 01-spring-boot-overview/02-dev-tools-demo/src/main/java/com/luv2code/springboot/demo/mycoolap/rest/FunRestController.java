package com.luv2code.springboot.demo.mycoolap.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/getCoachName")
    public String getCoachName() {
        return coachName;
    }

    @GetMapping("/getTeamName")
    public String getTeamName() {
        return teamName;
    }




    @GetMapping("/")
    public String sayHello(){

        return "Hello World 222";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "run hard 5k!";
    }




}
