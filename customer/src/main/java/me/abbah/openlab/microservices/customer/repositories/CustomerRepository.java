package me.abbah.openlab.microservices.customer.repositories;

import me.abbah.openlab.microservices.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
