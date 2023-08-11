package com.restful.dvdrental.service;

import com.restful.dvdrental.dao.IAddressDAO;
import com.restful.dvdrental.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    private IAddressDAO addressDAO;

    @Autowired
    public AddressServiceImpl(IAddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Override
    public List<Address> findAllAddress() {
        return addressDAO.findAll();
    }

    @Override
    public Optional<Address> findAddressById(int addressId) {
        return addressDAO.findById(addressId);
    }
}
