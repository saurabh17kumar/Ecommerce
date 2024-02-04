package com.example.peronalProject.demo.Service;

import com.example.peronalProject.demo.Entity.User;
import com.example.peronalProject.demo.Model.CommonModel;
import com.example.peronalProject.demo.Model.DumyData;
import com.example.peronalProject.demo.Model.LoginVallidation;

import java.util.List;


public interface Service {

    List<DumyData> getDataByModel();
    CommonModel saveUserDetails(User user);

     User userExist(String email, String password);

    LoginVallidation passwordMatch(String password, User user1);


}
