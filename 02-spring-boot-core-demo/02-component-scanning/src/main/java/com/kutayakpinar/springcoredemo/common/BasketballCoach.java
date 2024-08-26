package com.kutayakpinar.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



@Component
//@Lazy
public class BasketballCoach implements ICoach{

    public BasketballCoach() {
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {

        return "Basketball Coach";

    }
}
