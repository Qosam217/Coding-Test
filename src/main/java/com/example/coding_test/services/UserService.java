package com.example.coding_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coding_test.entities.User;
import com.example.coding_test.repositories.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    
    public User login(User user){
        User requestUser = userRepo.findByUsername(user.getUsername());
        if(requestUser.getPassword().equals(user.getPassword())){
            return requestUser;
        }else{
            return null;
        }
    }

    public User register(User user){
        if(userRepo.existsByUsername(user.getUsername())){
            return userRepo.save(user);
        }else{
            return null;
        }
    }
}
