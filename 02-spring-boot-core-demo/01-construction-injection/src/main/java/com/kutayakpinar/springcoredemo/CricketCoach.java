package com.kutayakpinar.springcoredemo;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements ICoach {

    @Override
    public String getDailyWorkout() {
        return "Hey practice fast for 15 minutes!!!!";
    }
}

