package com.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prod_num;

    private String productCategory;
    private String productName;
    private String productDescription;
    private String productAmount;
    
    private byte[] productImage; //1 image will be stored

    @ManyToOne
    @JoinColumn(name ="uni_num")
    private User user;
    
    @OneToOne
    @JoinColumn(name ="listings_num", unique = true)
    private Listings listings; 

}
