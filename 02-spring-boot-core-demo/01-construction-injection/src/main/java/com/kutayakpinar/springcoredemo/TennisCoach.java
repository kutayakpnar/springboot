package com.kutayakpinar.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements ICoach{


    @Override
    public String getDailyWorkout() {
        return "Tenniiiiss";
    }
}
