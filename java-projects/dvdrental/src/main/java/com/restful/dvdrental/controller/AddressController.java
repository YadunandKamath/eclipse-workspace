package com.restful.dvdrental.controller;

import com.restful.dvdrental.entity.Address;
import com.restful.dvdrental.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/dvdrental")
public class AddressController {

    private IAddressService addressService;

    @Autowired
    public AddressController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public String listAddress(Model model) {
        List<Address> addressList = addressService.findAllAddress();
        model.addAttribute("address", addressList);
        return "dvdrental/list-address";
    }

    @GetMapping("/address/{addressId}")
    Optional<Address> findAddressById(@PathVariable int addressId) {
        return addressService.findAddressById(addressId);
    }
}
