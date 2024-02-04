package com.example.peronalProject.demo.Controller;

import com.example.peronalProject.demo.Entity.User;
import com.example.peronalProject.demo.Model.CommonModel;
import com.example.peronalProject.demo.Model.DumyData;
import com.example.peronalProject.demo.Model.LoginVallidation;
import com.example.peronalProject.demo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ProjectController {
    @Autowired
    Service service;

    @GetMapping("/get-user-data")
    public List<DumyData> getDataFromUser(){
    return service.getDataByModel();
    }
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
}