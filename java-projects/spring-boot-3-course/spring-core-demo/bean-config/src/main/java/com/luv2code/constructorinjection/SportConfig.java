package com.luv2code.constructorinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("swimmer")
    public ICoach swimCoach(){
        return new SwimCoach();
    }
}
