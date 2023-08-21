package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl(){

        customerMap = new HashMap<>();

        CustomerDTO customerDTO1 = CustomerDTO.builder()
                .customerId(UUID.randomUUID())
                .customerName("John")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        CustomerDTO customerDTO2 = CustomerDTO.builder()
                .customerId(UUID.randomUUID())
                .customerName("Jane")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        CustomerDTO customerDTO3 = CustomerDTO.builder()
                .customerId(UUID.randomUUID())
                .customerName("Chris")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        CustomerDTO customerDTO4 = CustomerDTO.builder()
                .customerId(UUID.randomUUID())
                .customerName("Jay")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        CustomerDTO customerDTO5 = CustomerDTO.builder()
                .customerId(UUID.randomUUID())
                .customerName("Bob")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(customerDTO1.getCustomerId(), customerDTO1);
        customerMap.put(customerDTO2.getCustomerId(), customerDTO2);
        customerMap.put(customerDTO3.getCustomerId(), customerDTO3);
        customerMap.put(customerDTO4.getCustomerId(), customerDTO4);
        customerMap.put(customerDTO5.getCustomerId(), customerDTO5);
    }
    @Override
    public List<CustomerDTO> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID customerId) {
        return Optional.of(customerMap.get(customerId));
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        CustomerDTO newCustomerDTO = CustomerDTO.builder()
                .customerId(customerDTO.getCustomerId())
                .customerName(customerDTO.getCustomerName())
                .createdDate(customerDTO.getCreatedDate())
                .lastModifiedDate(customerDTO.getLastModifiedDate())
                .build();
        customerMap.put(newCustomerDTO.getCustomerId(), newCustomerDTO);
        return customerMap.get(newCustomerDTO.getCustomerId());
    }
}
