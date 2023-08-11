package com.restful.dvdrental.service;

import com.restful.dvdrental.dao.IActorDAO;
import com.restful.dvdrental.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements IActorService {

    private IActorDAO actorDAO;

    @Autowired
    public ActorServiceImpl(IActorDAO actorDAO) {
        this.actorDAO = actorDAO;
    }

    @Override
    public List<Actor> findAllActors() {
        return actorDAO.findAll();
    }

    @Override
    public Optional<Actor> findActorById(int actorId) {
        return actorDAO.findById(actorId);
    }
}
