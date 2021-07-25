package me.abbah.openlab.microservices.billing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.abbah.openlab.microservices.billing.entities.Customer;

import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponseDTO {
    private String id;
    private Date date;
    private BigInteger amount;
    private Customer customer;
}
