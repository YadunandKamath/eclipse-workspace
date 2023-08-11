package com.restful.dvdrental.service;

import com.restful.dvdrental.dao.ICityDAO;
import com.restful.dvdrental.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {

    private ICityDAO cityDAO;

    @Autowired
    public CityServiceImpl(ICityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    public List<City> findAllCities() {
        return cityDAO.findAll();
    }

    @Override
    public Optional<City> findCityById(int cityId) {
        return cityDAO.findById(cityId);
    }
}
