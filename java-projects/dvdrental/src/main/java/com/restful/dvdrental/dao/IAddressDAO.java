package com.restful.dvdrental.dao;

import com.restful.dvdrental.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressDAO extends JpaRepository<Address, Integer> {
}
