package com.luv2code.constructorinjection;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements ICoach {

    public CricketCoach(){
        System.out.println("Constructor: " + getClass().getSimpleName());
    }
    @PostConstruct
    private void cricketCoachInit(){
        System.out.println("Init method: cricketCoach");
    }
    @PreDestroy
    private void cricketCoachDestroy(){
        System.out.println("Destroy method: cricketCoach");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice bowling!!";
    }
}
