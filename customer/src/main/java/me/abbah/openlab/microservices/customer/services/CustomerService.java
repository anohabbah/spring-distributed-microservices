package me.abbah.openlab.microservices.customer.services;

import me.abbah.openlab.microservices.customer.dto.CustomRequestDTO;
import me.abbah.openlab.microservices.customer.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomRequestDTO customRequestDTO);
    CustomerResponseDTO getCustomer(String customerId);
    CustomerResponseDTO update(CustomRequestDTO customRequestDTO);
    List<CustomerResponseDTO> listCustomers();
}
