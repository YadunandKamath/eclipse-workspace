package com.luv2code.constructorinjection;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements ICoach {

    public FootballCoach(){
        System.out.println("Constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice shooting!!";
    }
}
