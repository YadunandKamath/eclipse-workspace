package com.restful.dvdrental.service;

import com.restful.dvdrental.entity.Actor;

import java.util.List;
import java.util.Optional;

public interface IActorService {

    List<Actor> findAllActors();
    Optional<Actor> findActorById(int actorId);
}
