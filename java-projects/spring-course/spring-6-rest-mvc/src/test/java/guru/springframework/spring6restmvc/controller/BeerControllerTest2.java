package guru.springframework.spring6restmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.spring6restmvc.controllers.BeerController;
import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.services.BeerService;
import guru.springframework.spring6restmvc.services.BeerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
public class BeerControllerTest2 {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    BeerService beerService;

    BeerServiceImpl beerServiceImpl;

    @BeforeEach
    void setUp(){
        beerServiceImpl = new BeerServiceImpl();
    }

    @Test
    void testCreateNewBeer() throws Exception {

        BeerDTO newBeerDTO = beerServiceImpl.listBeer().get(0);
//        newBeer.setVersion(null);
//        newBeer.setBeerId(null);

        given(beerService.saveBeer(any(BeerDTO.class))).willReturn(beerServiceImpl.listBeer().get(1));

        mockMvc.perform(post("/api/v1/beer")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newBeerDTO)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }
    @Test
    void testListBeers() throws Exception {

        given(beerService.listBeer()).willReturn(beerServiceImpl.listBeer());

        mockMvc.perform(get("/api/v1/beer/beers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()",is(3)));
    }

    @Test
    void getBeerByIdNotFound() throws Exception{

        given(beerService.getBeerByID(any(UUID.class))).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/beer/beers/9"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetBeerById() throws Exception {

        BeerDTO testBeerDTO = beerServiceImpl.listBeer().get(2);

        given(beerService.getBeerByID(any(UUID.class))).willReturn(Optional.of(testBeerDTO));

        mockMvc.perform(get("/api/v1/beer/beers/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.beerId", is(testBeerDTO.getBeerId())))
                .andExpect(jsonPath("$.beerName", is(testBeerDTO.getBeerName())));
    }
}
