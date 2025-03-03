package com.backend.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    

    @Column(unique =true)
    private String email;
    private String password;

    @ManyToMany(targetEntity = Role.class)
    private Set<Role> roles;
}
