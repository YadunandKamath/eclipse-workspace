package guru.springframework.spring6restmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.spring6restmvc.controllers.CustomerController;
import guru.springframework.spring6restmvc.exceptions.NotFoundException;
import guru.springframework.spring6restmvc.model.CustomerDTO;
import guru.springframework.spring6restmvc.services.CustomerService;
import guru.springframework.spring6restmvc.services.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    CustomerService customerService;

    CustomerServiceImpl customerServiceImpl;

    @BeforeEach
    void setUp(){
        customerServiceImpl = new CustomerServiceImpl();
    }

    @Test
    void testCreateNewCustomer() throws Exception {

        CustomerDTO newCustomerDTO = customerServiceImpl.listCustomers().get(0);
        newCustomerDTO.setCustomerId(UUID.randomUUID());

        given(customerService.saveCustomer(any(CustomerDTO.class))).willReturn(customerServiceImpl.listCustomers().get(1));

        mockMvc.perform(post("/api/v1/customer")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newCustomerDTO)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }
    @Test
    void testListCustomers() throws Exception {

        given(customerService.listCustomers()).willReturn(customerServiceImpl.listCustomers());

        mockMvc.perform(get("/api/v1/customer/customers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()",is(5)));
    }

    @Test
    void testGetCustomerById() throws Exception {

        CustomerDTO testCustomerDTO = customerServiceImpl.listCustomers().get(3);

        given(customerService.getCustomerById(any(UUID.class)))
                .willReturn(customerServiceImpl.getCustomerById(UUID.randomUUID()));

        mockMvc.perform(get("/api/v1/customer/customers/4")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.customerId", is(testCustomerDTO.getCustomerId())))
                .andExpect(jsonPath("$.customerName", is(testCustomerDTO.getCustomerName())));
    }

    @Test
    void getCustomerByIdNotFound() throws Exception{

        given(customerService.getCustomerById(any(UUID.class))).willThrow(NotFoundException.class);

        mockMvc.perform(get("/api/v1/customer/customers/9"))
                .andExpect(status().isNotFound());
    }
}
