package com.example.peronalProject.demo.Repository;

import com.example.peronalProject.demo.Entity.User;
import com.example.peronalProject.demo.Model.CommonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select e from User e where e.email=:email")
    User findByEmail(String email);
}
