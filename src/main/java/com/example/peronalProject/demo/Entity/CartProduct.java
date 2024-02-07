package com.example.peronalProject.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cart_product")
@Data
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "user_id")
    private Long userId;
}
