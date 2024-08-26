package com.kutayakpinar.springcoredemo.common;

public class SwimCoach implements ICoach{


    public SwimCoach() {
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        System.out.println(getClass().getSimpleName());
        return "Swimmm Coach";

    }
}
