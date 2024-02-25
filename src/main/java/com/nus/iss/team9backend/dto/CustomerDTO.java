package com.nus.iss.team9backend.dto;


public class CustomerDTO {
    private Long customer_id;
    private String name;
    private String email_address;
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
    public CustomerDTO(){

    }

    public CustomerDTO(Long customerId, String name, String emailAddress, Long phoneNumber) {
        this.customer_id=customerId;
        this.name=name;
        this.email_address=emailAddress;
        this.phone_number=phoneNumber;
    }
}
