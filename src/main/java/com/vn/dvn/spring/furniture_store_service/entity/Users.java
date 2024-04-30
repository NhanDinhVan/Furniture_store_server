package com.vn.dvn.spring.furniture_store_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "user")
public class Users {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "name", length = 255)
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "gender", length = 50)
    String gender;

    @Column(name = "purchased", length = 11)
    int purchased;

    @Column(name = "email", length = 255)
    String email;

    @Column(name = "phone_number", length = 20)
    String phoneNumber;

    @Column(name = "password", length = 255)
    String password;

    @Column(name = "role", length = 50)
    String role;

    @Column(name = "state", length = 50)
    String state;

    public Users(String name, String address, String gender, int purchased, String email, String phoneNumber, String password, String role, String state) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.purchased = purchased;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.state = state;
    }

}
