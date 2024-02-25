package com.nus.iss.team9backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_ROOMTYPE" )
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_type_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    public Long getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(Long room_type_id) {
        this.room_type_id = room_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public RoomType(){

    }

    public RoomType(Long room_type_id, String name, String description, Double price) {
        this.room_type_id = room_type_id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}