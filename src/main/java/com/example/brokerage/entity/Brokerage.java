package com.example.brokerage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Brokerage {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private Long price;
}
