package com.restful.dvdrental.service;

import com.restful.dvdrental.entity.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryService {

    List<Country> findAllCountries();
    Optional<Country> findCountryById(int countryId);
}
