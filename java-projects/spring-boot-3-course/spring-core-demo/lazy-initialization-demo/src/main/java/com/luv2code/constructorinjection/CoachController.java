package com.luv2code.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    private ICoach coach;

    public CoachController(){
        System.out.println(getClass().getSimpleName());
    }

    @Autowired
    public void setCoach(@Qualifier("cricketCoach") ICoach coach){
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return this.coach.getDailyWorkout();
    }
}
