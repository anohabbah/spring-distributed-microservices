package me.abbah.openlab.microservices.customer.services;

import me.abbah.openlab.microservices.customer.dto.CustomRequestDTO;
import me.abbah.openlab.microservices.customer.dto.CustomerResponseDTO;
import me.abbah.openlab.microservices.customer.entities.Customer;
import me.abbah.openlab.microservices.customer.mappers.CustomerMapper;
import me.abbah.openlab.microservices.customer.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    @Override
    public CustomerResponseDTO save(CustomRequestDTO customRequestDTO) {
        Customer customer = customerRepository.save(customerMapper.customerRequestDTOToCustomer(customRequestDTO));
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO getCustomer(String customerId) {
        return customerMapper.customerToCustomerResponseDTO(customerRepository.getById(customerId));
    }

    @Override
    public CustomerResponseDTO update(CustomRequestDTO customRequestDTO) {
        Customer customer = customerRepository.save(customerMapper.customerRequestDTOToCustomer(customRequestDTO));
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customer -> customerMapper.customerToCustomerResponseDTO(customer))
                .collect(Collectors.toList());
    }
}
