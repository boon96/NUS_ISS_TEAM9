package com.nus.iss.team9backend.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private Long adminId;
    private String name;
    private String emailAddress;
    private Long phoneNumber;
    private String password;

}
