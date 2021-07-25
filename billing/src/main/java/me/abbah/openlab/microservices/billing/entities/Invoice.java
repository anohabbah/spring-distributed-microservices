package me.abbah.openlab.microservices.billing.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigInteger;
import java.util.Date;

@Entity(name = "invoices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    private String id;
    private Date date;
    private BigInteger amount;
    private String customerId;
    @Transient
    private Customer customer;
}
