package com.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="listings")
public class Listings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long listings_num;

    private String productCategory;
    private String productName;
    private String productDescription;
    private String productAmount;
    
    
    @OneToOne(mappedBy ="listings", cascade = CascadeType.ALL)
    private Orders orders; 

    @OneToOne(mappedBy ="listings", cascade = CascadeType.ALL)
    private Products products; 

}