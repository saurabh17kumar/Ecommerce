package com.example.peronalProject.demo.Model;

import com.example.peronalProject.demo.Entity.ProductDetails;
import lombok.Data;

import java.util.List;

@Data
public class CommonModel {
    private String msg;
    private String code;
    private List<ProductDetails>productDetailsList;
}
