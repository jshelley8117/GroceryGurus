package com.JERZ.GroceryGurus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@Table(name = "authorities")
@RequiredArgsConstructor
@AllArgsConstructor

public class Authority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "authority")
    private Boolean authority;
}
