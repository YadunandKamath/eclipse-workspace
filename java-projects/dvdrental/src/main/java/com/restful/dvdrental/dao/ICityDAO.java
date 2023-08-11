package com.restful.dvdrental.dao;

import com.restful.dvdrental.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityDAO extends JpaRepository<City, Integer> {
}
