package com.restful.dvdrental.controller;

import com.restful.dvdrental.entity.City;
import com.restful.dvdrental.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/dvdrental")
public class CityController {

    private ICityService cityService;
    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public String listCities(Model model){

        List<City> cityList = cityService.findAllCities();
        model.addAttribute("city",cityList);
        return "dvdrental/list-city";
    }
}
