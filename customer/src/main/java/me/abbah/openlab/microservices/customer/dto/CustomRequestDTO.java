package me.abbah.openlab.microservices.customer.dto;

import lombok.Data;

@Data
public class CustomRequestDTO {
    private String id;
    private String name;
    private String email;
}
