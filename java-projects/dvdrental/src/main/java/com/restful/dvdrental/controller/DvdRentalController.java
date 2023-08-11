package com.restful.dvdrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DvdRentalController {

    @RequestMapping(method = RequestMethod.GET, value = "/api/dvdrental")
    public String homePage(){
        return "templates/dvdrental/home-page.html";
    }
}
