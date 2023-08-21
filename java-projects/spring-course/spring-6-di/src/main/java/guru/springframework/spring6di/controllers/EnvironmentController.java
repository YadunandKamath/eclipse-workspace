package guru.springframework.spring6di.controllers;

import guru.springframework.spring6di.services.IEnvironmentService;
import org.springframework.stereotype.Controller;

@Controller
public class EnvironmentController {

    private final IEnvironmentService environmentService;

    public EnvironmentController(IEnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    public String getEnvironment(){
        return "This is the " + environmentService.getEnv() + " environment.";
    }
}
