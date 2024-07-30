package com.JERZ.GroceryGurus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@Table(name = "customers")
@RequiredArgsConstructor
@AllArgsConstructor

public class Customer {

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String password;

    private String streetAddress;

    private String phoneNumber;

    private Integer age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
