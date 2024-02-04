package com.example.peronalProject.demo.ServiceImpl;

import com.example.peronalProject.demo.Entity.User;
import com.example.peronalProject.demo.Model.CommonModel;
import com.example.peronalProject.demo.Model.DumyData;
import com.example.peronalProject.demo.Model.LoginVallidation;
import com.example.peronalProject.demo.Repository.UserRepository;
import com.example.peronalProject.demo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Autowired
    UserRepository userRepository;
    BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder();

    public List<DumyData> getDataByModel(){
        List<DumyData> dumyDataList = new ArrayList<>();
        DumyData dumyData = new DumyData();
        DumyData dumyData1 = new DumyData();
        DumyData dumyData2 = new DumyData();
        DumyData dumyData3 = new DumyData();
        DumyData dumyData4 = new DumyData();
        DumyData dumyData5 = new DumyData();
        DumyData dumyData6 = new DumyData();
        DumyData dumyData7 = new DumyData();
        DumyData dumyData8 = new DumyData();
        DumyData dumyData9 = new DumyData();
        DumyData dumyData10 = new DumyData();

        dumyData.setName("Bata");
        dumyData.setSize("8");
        dumyData.setColor("black");
        dumyData.setType("bata");
        dumyData.setLink("https://www.bata.com/dw/image/v2/BCLG_PRD/on/demandware.static/-/Sites-bata-in-master-catalog/default/dw87fe6d91/images/tile/3396564_2.jpeg?sw=660");

        dumyData1.setName("Bata");
        dumyData1.setSize("10");
        dumyData1.setColor("blue");
        dumyData1.setType("sandals");
        dumyData1.setLink("data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==");

        dumyData2.setName("Bata");
        dumyData2.setSize("10");
        dumyData2.setColor("blue");
        dumyData2.setType("sandals");
        dumyData2.setLink("data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==");

        dumyData3.setName("Bata");
        dumyData3.setSize("10");
        dumyData3.setColor("blue");
        dumyData3.setType("sandals");
        dumyData3.setLink("data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==");

        dumyData4.setName("Bata");
        dumyData4.setSize("10");
        dumyData4.setColor("blue");
        dumyData4.setType("sandals");
        dumyData4.setLink("data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==");

        dumyData5.setName("Bata");
        dumyData5.setSize("10");
        dumyData5.setColor("blue");
        dumyData5.setType("sandals");
        dumyData5.setLink("data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==");

        dumyData6.setName("Bata");
        dumyData6.setSize("10");
        dumyData6.setColor("blue");
        dumyData6.setType("sandals");
        dumyData6.setLink("data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==");

        dumyData7.setName("Bata");
        dumyData7.setSize("10");
        dumyData7.setColor("blue");
        dumyData7.setType("sandals");
        dumyData7.setLink("data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==");

        dumyData8.setName("Bata");
        dumyData8.setSize("10");
        dumyData8.setColor("blue");
        dumyData8.setType("sandals");
        dumyData8.setLink("data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==");

        dumyData9.setName("Bata");
        dumyData9.setSize("10");
        dumyData9.setColor("blue");
        dumyData9.setType("sandals");
        dumyData9.setLink("data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==");

        dumyData10.setName("Bata");
        dumyData10.setSize("10");
        dumyData10.setColor("blue");
        dumyData10.setType("sandals");
        dumyData10.setLink("data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==");

        dumyDataList.add(dumyData);
        dumyDataList.add(dumyData1);
        dumyDataList.add(dumyData2);
        dumyDataList.add(dumyData3);
        dumyDataList.add(dumyData4);
        dumyDataList.add(dumyData5);
        dumyDataList.add(dumyData6);
        dumyDataList.add(dumyData7);
        dumyDataList.add(dumyData8);
        dumyDataList.add(dumyData9);
        dumyDataList.add(dumyData10);
        return dumyDataList;
    }
   public CommonModel saveUserDetails(User user){
       CommonModel commonModel = new CommonModel();

       String password = PasswordEncoder.encode(user.getPassword());
       user.setPassword(password);

       try {
           if (user.getEmail() != null && user.getName() != null && user.getEmail() != null && user.getPassword() != null && user.getMobileNo() != null) {
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
   public User userExist(String email, String password){
       CommonModel commonModel = new CommonModel();
        return userRepository.findByEmail(email);
   }


    public LoginVallidation passwordMatch(String password, User user1){
        LoginVallidation commonModel = new LoginVallidation();
       if (PasswordEncoder.matches(password, user1.getPassword())){
           commonModel.setCode("0000");
           commonModel.setMsg("Login successfully");
           commonModel.setName(user1.getName());
           commonModel.setEmail(user1.getEmail());
       }else {
           commonModel.setCode("1111");
           commonModel.setMsg("Password did not matched");
       }
       return commonModel;
    }

}