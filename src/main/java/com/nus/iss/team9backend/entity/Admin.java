package com.nus.iss.team9backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TBL_ADMIN" )
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    @Column(name="name")
    private String name;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="phone_number")
    private Long phoneNumber;

    @Column(name="password")
    private String password;
}
