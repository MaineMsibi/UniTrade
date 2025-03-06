package com.backend.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;// this generates getters and setters! nice

@Data
@Entity
@Table(name ="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uni_num;

    private String name;
    private String username;
    private String userType;
    private String cellNumber;
    private String aboutInfo;    
    private byte[] profilePic; //for storing images, not conventional large scale

    @Column(unique =true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Products> products = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Orders> orders = new HashSet<>();
    
}

