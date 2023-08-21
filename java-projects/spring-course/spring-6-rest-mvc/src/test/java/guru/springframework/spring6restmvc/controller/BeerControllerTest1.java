package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.controllers.BeerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeerControllerTest1 {

    @Autowired
    BeerController beerController;

    @Test
    void getBeerById() throws Exception {

        System.out.println(beerController.getBeerById(2L));
    }
}
