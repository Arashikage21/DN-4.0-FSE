package com.cognizant.jpa_demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    // constructors, getters, setters

    public Employee() { }

    public Employee(String name) {
        this.name = name;
    }

    // getters/setters omitted for brevity
}

