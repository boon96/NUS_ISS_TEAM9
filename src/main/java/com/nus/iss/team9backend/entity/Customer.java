package com.nus.iss.team9backend.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "TBL_CUSTOMER" )
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    @Column(name="name")
    private String name;

    @Column(name="email_address")
    private String email_address;

    @Column(name="phone_number")
    private Long phone_number;

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }
    public Customer(){

    }

    public Customer(Long customer_id, String name, String email_address, Long phone_number) {
        this.customer_id = customer_id;
        this.name = name;
        this.email_address = email_address;
        this.phone_number = phone_number;
    }
}
