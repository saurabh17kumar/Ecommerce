package com.example.peronalProject.demo.Repository;

import com.example.peronalProject.demo.Entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct,Long> {

}
