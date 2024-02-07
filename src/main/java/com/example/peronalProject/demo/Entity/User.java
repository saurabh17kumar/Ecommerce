package com.example.peronalProject.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "mobileNo")
    private Long mobileNo;

//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    private List<ProductDetails> productDetailsList;
}
