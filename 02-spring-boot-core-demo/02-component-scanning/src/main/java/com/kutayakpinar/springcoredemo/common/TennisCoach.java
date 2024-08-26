package com.kutayakpinar.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements ICoach{

    public TennisCoach() {
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {

        return "Tennis Coach";
    }
}
