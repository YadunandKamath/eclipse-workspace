package com.restful.dvdrental.dao;

import com.restful.dvdrental.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IActorDAO extends JpaRepository<Actor, Integer> {

}
