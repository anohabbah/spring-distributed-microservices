package me.abbah.openlab.microservices.customer.web;

import me.abbah.openlab.microservices.customer.dto.CustomRequestDTO;
import me.abbah.openlab.microservices.customer.dto.CustomerResponseDTO;
import me.abbah.openlab.microservices.customer.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/customers")
public class CustomerRestController {
    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "")
    public List<CustomerResponseDTO> allCustomers() {
        return customerService.listCustomers();
    }

    @PostMapping(path = "")
    public CustomerResponseDTO store(@RequestBody CustomRequestDTO customRequestDTO) {
        customRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customRequestDTO);
    }

    @GetMapping(path = "{customerId}")
    public CustomerResponseDTO show(@PathVariable String customerId) {
        return customerService.getCustomer(customerId);
    }
}
