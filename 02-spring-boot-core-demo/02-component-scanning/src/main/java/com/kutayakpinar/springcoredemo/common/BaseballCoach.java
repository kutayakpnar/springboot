package com.kutayakpinar.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements ICoach{

    public BaseballCoach() {
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {

        return "baseball coach";
    }
}
