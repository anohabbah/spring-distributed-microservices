package me.abbah.openlab.microservices.customer.mappers;

import me.abbah.openlab.microservices.customer.dto.CustomRequestDTO;
import me.abbah.openlab.microservices.customer.dto.CustomerResponseDTO;
import me.abbah.openlab.microservices.customer.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomRequestDTO customRequestDTO);
}
