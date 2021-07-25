package me.abbah.openlab.microservices.billing.entities;

import lombok.Data;


@Data
public class Customer {
    private String id;
    private String name;
    private String email;
}
