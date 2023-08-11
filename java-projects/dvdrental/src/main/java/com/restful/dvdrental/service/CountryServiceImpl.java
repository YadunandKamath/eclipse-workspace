package com.restful.dvdrental.service;

import com.restful.dvdrental.dao.ICountryDAO;
import com.restful.dvdrental.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements ICountryService {

    private ICountryDAO countryDAO;
    @Autowired
    public CountryServiceImpl(ICountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    @Override
    public List<Country> findAllCountries() {
        return countryDAO.findAll();
    }

    @Override
    public Optional<Country> findCountryById(int countryId) {
        return countryDAO.findById(countryId);
    }
}
