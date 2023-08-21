package com.luv2code.constructorinjection;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements ICoach {
    @Override
    public String getDailyWorkout() {
        return "Practice bowling!!";
    }
}
