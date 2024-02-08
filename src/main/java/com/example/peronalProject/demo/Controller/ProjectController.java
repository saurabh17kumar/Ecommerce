package com.example.peronalProject.demo.Controller;

import com.example.peronalProject.demo.Entity.CartProduct;
import com.example.peronalProject.demo.Entity.ProductDetails;
import com.example.peronalProject.demo.Entity.User;
import com.example.peronalProject.demo.Model.CommonModel;
import com.example.peronalProject.demo.Model.LoginVallidation;
import com.example.peronalProject.demo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ProjectController {
    @Autowired
    Service service;

<<<<<<< Updated upstream
    //Post product data in product detail entity
    @PostMapping("/post-product-details")
    public CommonModel userDetailsave(@RequestBody ProductDetails productDetails){
        CommonModel commonModel = new CommonModel();
        commonModel = service.uploadProductData(productDetails);
        return commonModel;
=======
    @GetMapping("/get_data_for_project")
    public List<DumyData> getDataFromUser(){
    return service.getDataByModel();
>>>>>>> Stashed changes
    }

    //API for get all product data
    @GetMapping("/get-product-data")
    public List<ProductDetails> getDataFromUser(){
    return service.getAllProduct();
    }

    //Post User Details in user entity
   @PostMapping("/post-user-details")
    public CommonModel userDetailsave(@RequestBody User user){
       CommonModel commonModel = new CommonModel();
       String emailVallidation =user.getEmail();
       if (emailVallidation.contains("@gmail.")) {
           commonModel = service.saveUserDetails(user);
       }else {
           commonModel.setCode("1111");
           commonModel.setMsg("Please inter Valid Email");
       }
       return commonModel;
   }

   //API for Get user details from user entity
    @GetMapping("/get-user-all-data")
    public List<User> getAllUser(){
        return service.getAll();
    }

   //Check user login validation for login
   @PostMapping("/validation")
    public LoginVallidation userLoginValidation(@RequestBody User user){
       User user1  = new User();
       LoginVallidation commonModel = new LoginVallidation();
        String email = user.getEmail();
        String password = user.getPassword();
        if (!email.isEmpty() && email.contains("@gmail.") && !password.isEmpty()){
            user1 = service.userExist(email,password);
            if (user1 != null){
                commonModel = service.passwordMatch(password,user1);
            }else {
                commonModel.setCode("1111");
                commonModel.setMsg("User does not exist");
            }
        }else {
            commonModel.setCode("1111");
            commonModel.setMsg("Invalid user email");
        }
        return commonModel;
   }

    //API for get data from category wise from productDetails table
    @GetMapping("/get-productdetails-data")
    public CommonModel getDataCategoryWise(@RequestParam(name = "category",required = false)String category, @RequestParam(name = "name",required = false)String name, @RequestParam(name = "iteam",required = false)String iteam, @RequestParam(name = "size",required = false)String size, @RequestParam(name = "colour",required = false)String colour){
        List<ProductDetails>productDetails = new ArrayList<>();
        CommonModel commonModel = new CommonModel();
        productDetails = service.getdataBycategory(category,name,iteam,size,colour);
        if (!productDetails.isEmpty()){
            commonModel.setCode("0000");
            commonModel.setMsg("Data Found Successfully");
            commonModel.setProductDetailsList(productDetails);
        }else {
            commonModel.setCode("1111");
            commonModel.setMsg("Data Not Found");
        }
        return commonModel;
    }

    //Api for post userId and productId in cartProduct entity
    @PostMapping("/post-userid-productid")
    public CommonModel uploadDatainCartDetails(@RequestBody CartProduct cartProduct){
        CommonModel commonModel = new CommonModel();
      if (cartProduct.getProductId() != null && cartProduct.getUserId() != null){
          commonModel = service.postDataForAddtoCart(cartProduct);
      }else {
          commonModel.setCode("1111");
          commonModel.setMsg("Please fill all field");
      }
      return commonModel;
    }

    // Api for
//    @GetMapping("/get-data-user-and-productDetails")
//    public List<User>getDataFromUserAndProductDetails(@RequestParam("userId")Long userId,@RequestParam("productId")Long productId){
//        List<User>userList = new ArrayList<>();
//        if (userId != null && productId != null){
//            userList = service.getDataFromUserAndProductDetails(userId,productId);
//        }
//        return userList;
//    }

//    @GetMapping("/get-mapped")
}