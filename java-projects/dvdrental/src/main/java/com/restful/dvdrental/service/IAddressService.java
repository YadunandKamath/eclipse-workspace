package com.restful.dvdrental.service;

import com.restful.dvdrental.entity.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressService {

    List<Address> findAllAddress();
    Optional<Address> findAddressById(int addressId);
}
