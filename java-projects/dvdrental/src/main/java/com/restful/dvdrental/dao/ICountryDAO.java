package com.restful.dvdrental.dao;

import com.restful.dvdrental.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryDAO extends JpaRepository<Country, Integer> {
}
