package com.luv2code.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    private ICoach coach;
    private  ICoach anotherCoach;
    public CoachController(@Qualifier("cricketCoach") ICoach coach,
                           @Qualifier("cricketCoach") ICoach anotherCoach){
        System.out.println(getClass().getSimpleName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return this.coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String checkScope(){
        return "coach == anotherCoach: " + (this.coach == this.anotherCoach);
    }
}
