package com.example.peronalProject.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product_details")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private String size;
    @Column(name = "colour")
    private String colour;
    @Column(name = "iteam")
    private String iteam;
    @Column(name = "link")
    private String link;
    @Column(name = "category")
    private String category;

//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "id")
//    private User user;
}