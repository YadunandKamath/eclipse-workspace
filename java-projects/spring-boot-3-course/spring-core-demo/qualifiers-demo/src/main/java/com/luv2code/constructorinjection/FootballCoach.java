package com.luv2code.constructorinjection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootballCoach implements ICoach {
    @Override
    public String getDailyWorkout() {
        return "Practice shooting!!";
    }
}
