package com.restful.dvdrental.service;

import com.restful.dvdrental.entity.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {

    List<City> findAllCities();
    Optional<City> findCityById(int cityId);
}
