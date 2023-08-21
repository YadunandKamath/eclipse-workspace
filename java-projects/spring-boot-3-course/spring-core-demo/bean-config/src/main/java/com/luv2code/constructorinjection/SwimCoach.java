package com.luv2code.constructorinjection;

public class SwimCoach implements ICoach {

    public SwimCoach() {
        System.out.println("Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim freestyle 100m";
    }
}
