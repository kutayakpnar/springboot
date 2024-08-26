package com.kutayakpinar.springcoredemo.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements ICoach {

    public CricketCoach() {
        System.out.println(getClass().getSimpleName());
    }

    @PostConstruct
    public void beforeDo(){
        System.out.println("post construct" + getClass().getSimpleName());

    }

    @PreDestroy
    public void laterDo(){
        System.out.println("pre destroy" + getClass().getSimpleName());

    }

    @Override
    public String getDailyWorkout() {

        return "Hey practice fast for 15 minutes!!!!";
    }

}

