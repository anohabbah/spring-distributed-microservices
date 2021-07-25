package me.abbah.openlab.microservices.billing.openfeign;

import me.abbah.openlab.microservices.billing.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "CUSTOMER-CLIENT")
public interface CustomerRestClient {
    @GetMapping(path = "/api/customers/{customerId}")
    Customer getCustomer(@PathVariable String customerId);

    @GetMapping(path = "/api/customers")
    List<Customer> getAllCustomers();
}
