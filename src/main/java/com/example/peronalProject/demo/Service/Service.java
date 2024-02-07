package com.example.peronalProject.demo.Service;

import com.example.peronalProject.demo.Entity.CartProduct;
import com.example.peronalProject.demo.Entity.ProductDetails;
import com.example.peronalProject.demo.Entity.User;
import com.example.peronalProject.demo.Model.CommonModel;
import com.example.peronalProject.demo.Model.LoginVallidation;

import java.util.List;


public interface Service {

    CommonModel uploadProductData(ProductDetails productDetails);
    List<ProductDetails> getAllProduct();


    CommonModel saveUserDetails(User user);
    List<User> getAll();


     User userExist(String email, String password);
    LoginVallidation passwordMatch(String password, User user1);


    List<ProductDetails> getdataBycategory(String category,String name,String iteam,String size,String colour);
    CommonModel postDataForAddtoCart(CartProduct cartProduct);


//    List<User> getDataFromUserAndProductDetails(Long userId, Long productId);

}
