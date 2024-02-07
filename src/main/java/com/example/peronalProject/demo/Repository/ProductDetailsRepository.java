package com.example.peronalProject.demo.Repository;

import com.example.peronalProject.demo.Entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface ProductDetailsRepository extends JpaRepository<ProductDetails,Long> {

    @Query("select d from ProductDetails d " +
            "WHERE (:category is null or d.category =:category )"+
            "AND (:name IS NULL OR d.name = :name) " +
            "AND (:iteam IS NULL OR d.iteam = :iteam)" +
            "AND (:size IS NULL OR d.size = :size)" +
            "AND (:colour IS NULL OR d.colour = :colour)")
    List<ProductDetails> findByCategory(String category, String name, String iteam, String size, String colour);
    }