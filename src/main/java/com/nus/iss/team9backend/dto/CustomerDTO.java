package com.nus.iss.team9backend.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDTO {
    private Long customerId;
    private String name;
    private String emailAddress;
    private Long phoneNumber;

}
