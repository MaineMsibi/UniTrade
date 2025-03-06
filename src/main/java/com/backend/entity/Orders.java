package com.backend.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name ="orders")
public class Orders {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long order_num;
    
        @Column(nullable = false)
        private LocalDateTime orderDate;
        
        
        @ManyToOne
        @JoinColumn(name ="uni_num")
        private User user;

        @OneToOne
        @JoinColumn(name ="listings_num", unique = true)
        private Listings listings;        
}