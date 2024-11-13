package com.eklakh.quiz_test.service;

import com.eklakh.quiz_test.entity.User;
import com.eklakh.quiz_test.repo.RegRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    RegRepo Reg;

    public User userSave(User user){
        User registration = Reg.save(user);
        return registration;
    }
    public List<User> getAllData(){
        List<User> listdata = Reg.findAll();
        return listdata;
    }

}