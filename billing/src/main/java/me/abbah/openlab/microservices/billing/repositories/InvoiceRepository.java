package me.abbah.openlab.microservices.billing.repositories;

import me.abbah.openlab.microservices.billing.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    List<Invoice> findByCustomerId(String customerId);
}
