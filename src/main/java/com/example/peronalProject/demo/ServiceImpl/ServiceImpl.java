package com.example.peronalProject.demo.ServiceImpl;

import com.example.peronalProject.demo.Entity.CartProduct;
import com.example.peronalProject.demo.Entity.ProductDetails;
import com.example.peronalProject.demo.Entity.User;
import com.example.peronalProject.demo.Model.CommonModel;
import com.example.peronalProject.demo.Model.LoginVallidation;
import com.example.peronalProject.demo.Repository.CartProductRepository;
import com.example.peronalProject.demo.Repository.ProductDetailsRepository;
import com.example.peronalProject.demo.Repository.UserRepository;
import com.example.peronalProject.demo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductDetailsRepository productDetailsRepository;
    @Autowired
    private CartProductRepository cartProductRepository;
    BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder();

    //Method for upload product detail and product data
    public CommonModel uploadProductData(ProductDetails productDetails){
        CommonModel commonModel = new CommonModel();
        if (productDetails.getSize() != null && productDetails.getLink() != null && productDetails.getColour() != null && productDetails.getCategory() != null) {
            productDetailsRepository.save(productDetails);
            commonModel.setMsg("Data save successfully");
            commonModel.setCode("0000");
        }else {
            commonModel.setCode("1111");
            commonModel.setMsg("Data not save");
        }
        return commonModel;
    }

<<<<<<< Updated upstream
    //Get All product data
    public List<ProductDetails> getAllProduct() {
        List<ProductDetails> productDetails = new ArrayList<>();
        productDetails = productDetailsRepository.findAll();
        return productDetails;
    }

    //Upload the user details in table
    public CommonModel saveUserDetails(User user){
        CommonModel commonModel = new CommonModel();
        User existingEmail = userRepository.findByEmail(user.getEmail());
        if (existingEmail == null) {
            String password = PasswordEncoder.encode(user.getPassword());
            user.setPassword(password);
            try {
                if (user.getEmail() != null && user.getName() != null && user.getPassword() != null && user.getMobileNo() != null) {
                    userRepository.save(user);
                    commonModel.setCode("0000");
                    commonModel.setMsg("Data save successfully");
                } else {
                    commonModel.setCode("1111");
                    commonModel.setMsg("Please fill Required field");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            commonModel.setCode("1111");
            commonModel.setMsg("Email Already Exist");
        }
        return commonModel;
    }

    // method for get all user data from user
    public List<User> getAll(){
        List<User>userList = new ArrayList<>();
        userList = userRepository.findAll();
        return userList;
    }

   //Method for check this email exist or not
=======
       String password = PasswordEncoder.encode(user.getPassword());
       user.setPassword(password);
       

       try {
           if (user.getEmail() != null && user.getName() != null && user.getPassword() != null && user.getMobileNo() != null) {
               userRepository.save(user);
               commonModel.setCode("0000");
               commonModel.setMsg("Data save successfully");
           } else {
               commonModel.setCode("1111");
               commonModel.setMsg("Please fill Required field");
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       return commonModel;
   }
>>>>>>> Stashed changes
   public User userExist(String email, String password){
       CommonModel commonModel = new CommonModel();
        return userRepository.findByEmail(email);
   }

   //Validation check for login and match the email and password
    public LoginVallidation passwordMatch(String password, User user1){
        LoginVallidation commonModel = new LoginVallidation();
        try{
       if (PasswordEncoder.matches(password, user1.getPassword())){
           commonModel.setCode("0000");
           commonModel.setMsg("Login successfully");
           commonModel.setName(user1.getName());
           commonModel.setEmail(user1.getEmail());
       }else {
           commonModel.setCode("1111");
           commonModel.setMsg("Password did not matched");
       }
    }catch(Exception e){
        System.out.println(e);
    }
       return commonModel;
    }

    //get data from productDetails base of category
    public List<ProductDetails> getdataBycategory(String category,String name,String iteam,String size,String colour){
        List<ProductDetails> productDetailsList = new ArrayList<>();
        CommonModel commonModel = new CommonModel();
        try {
                productDetailsList = productDetailsRepository.findByCategory(category,name,iteam,size,colour);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
       return productDetailsList;
    }

    // Method for post data in add to cart entity
    public CommonModel postDataForAddtoCart(CartProduct cartProduct){
        CommonModel commonModel = new CommonModel();
        cartProductRepository.save(cartProduct);
        commonModel.setCode("0000");
        commonModel.setMsg("Data save successfully");
        return commonModel;
    }

    // Method for
//    public List<User> getDataFromUserAndProductDetails(Long userId, Long productId){
//
//    }





}