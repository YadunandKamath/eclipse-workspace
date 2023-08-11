package com.restful.dvdrental.controller;

import com.restful.dvdrental.entity.City;
import com.restful.dvdrental.entity.Country;
import com.restful.dvdrental.service.ICityService;
import com.restful.dvdrental.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/dvdrental")
public class CountryController {

    private ICountryService countryService;
    @Autowired
    public CountryController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public String listCountries(Model model){

        List<Country> countryList = countryService.findAllCountries();
        model.addAttribute("country",countryList);
        return "dvdrental/list-country";
    }
}
