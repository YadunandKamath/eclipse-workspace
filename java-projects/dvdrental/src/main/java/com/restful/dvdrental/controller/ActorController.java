package com.restful.dvdrental.controller;

import com.restful.dvdrental.entity.Actor;
import com.restful.dvdrental.service.IActorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/dvdrental")
public class ActorController {

    IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    public String listActors(Model model){
        List<Actor> actors = actorService.findAllActors();
        model.addAttribute("actors",actors);
        return "dvdrental/list-actors";
    }

    @GetMapping("/actors/{actorId}")
    Optional<Actor> findActorById(@PathVariable int actorId){
        return actorService.findActorById(actorId);
    }

}
