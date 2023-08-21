package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.exceptions.NotFoundException;
import guru.springframework.spring6restmvc.model.CustomerDTO;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public String customerHome(){
        log.debug("customerHome method in beerController");
        return "Welcome to the Brewery!\n\n" +
                "/customers - Get list of customers\n" +
                "/customers/{customerId} - Get customer by ID\n";
    }
    @RequestMapping(value = "/customers",method = RequestMethod.GET)
    public List<CustomerDTO> listCustomers(){
        log.debug("listCustomers method in customerController");
        return customerService.listCustomers();
    }

    @RequestMapping(value = "/customers/{customerId}",method = RequestMethod.GET)
    public CustomerDTO getCustomerById(@PathVariable(name = "customerId") UUID customerId){
        log.debug("getCustomerById method in customerController");
        return customerService.getCustomerById(customerId).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO customerDTO){

        log.debug("saveCustomer method in customerController");
        return ResponseEntity.created(URI.create("/api/v1/customer/customers/" + customerDTO.getCustomerId().toString()))
                .body(customerService.saveCustomer(customerDTO));
    }

}
