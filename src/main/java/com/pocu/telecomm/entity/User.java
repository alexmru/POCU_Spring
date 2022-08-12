package com.pocu.telecomm.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer age;


    @JsonIgnore
    @ManyToMany(mappedBy = "subscribedUsers")
    private Set<Plan> plans = new HashSet<>();

    public User(String name, String address, Integer age) {
        if(name == null || name.isBlank()) {
            throw new RuntimeException("User name must not be null");
        }
        else {
            this.name = name;
        }
        if(address == null || address.isBlank()) {
            throw new RuntimeException("Address must not be null");
        }
        else {
            this.address = address;
        }
        if (age < 0)
            throw new RuntimeException("Age cannot be negative");
        else {
            this.age = age;
        }
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Plan> getPlans() {
        return plans;
    }

    public void setPlans(Set<Plan> plans) {
        this.plans = plans;
    }
}
