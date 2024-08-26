package com.kutayakpinar.springcoredemo.config;


import com.kutayakpinar.springcoredemo.common.ICoach;
import com.kutayakpinar.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class sportConfig {

    @Bean("aquatic")
    public ICoach swimCoachBean(){
        return new SwimCoach();

    }
}
