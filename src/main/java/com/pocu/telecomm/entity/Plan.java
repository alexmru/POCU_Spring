package com.pocu.telecomm.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany
    @JoinTable(
            name = "SubscribedUsers",
            joinColumns = @JoinColumn(name= "plan_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> subscribedUsers = new HashSet<>();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String minutes;

    @Column(nullable = false)
    private Integer datasize;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "network_id",referencedColumnName = "id")
    private NetworkProvider networkProvider;

    public Plan() {

    }

    public void addUser(User user) {
        subscribedUsers.add(user);
    }

    public Plan(String name, Integer price, String minutes, Integer datasize) {
        if(name == null || name.isBlank()) {
            throw new RuntimeException("Name must not be null");
        }
        else {
            this.name = name;
        }
        if (price <0){
            throw new RuntimeException("Price must not be negative");
        }

        else {
            this.price = price;
        }


        this.minutes = minutes;
        if (datasize <0){
            throw new RuntimeException("Data must not be negative");
        }
        this.datasize = datasize;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getSubscribedUsers() {
        return subscribedUsers;
    }

    public void setSubscribedUsers(Set<User> subscribedUsers) {
        this.subscribedUsers = subscribedUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public Integer getDatasize() {
        return datasize;
    }

    public void setDatasize(Integer datasize) {
        this.datasize = datasize;
    }

    public NetworkProvider getNetworkProvider() {
        return networkProvider;
    }

    public void setNetworkProvider(NetworkProvider networkProvider) {
        this.networkProvider = networkProvider;
    }

    public void chooseNetwork(NetworkProvider network) {
        this.networkProvider = network;
    }

    public void subscribeUser(User user) {
        subscribedUsers.add(user);
    }
}
