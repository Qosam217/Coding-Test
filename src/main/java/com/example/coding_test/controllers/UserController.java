package com.example.coding_test.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coding_test.dtos.UserDto;
import com.example.coding_test.entities.User;
import com.example.coding_test.services.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserDto dto) {
         Map<String, Object> response = new HashMap<>();
        try {
            User requestedUser = new User();
            requestedUser.setUsername(dto.getUsername());
            requestedUser.setPassword(dto.getPassword());
            User responseUser = userService.login(requestedUser);
            if (responseUser != null) {
                response.put("message", "Success Login");
                response.put("data", "user id : " + responseUser.getId());
            }else{
                response.put("message", "Failed to Login");
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserDto dto) {
        Map<String, Object> response = new HashMap<>();
        try {
            User requestedUser = new User();
            requestedUser.setUsername(dto.getUsername());
            requestedUser.setPassword(dto.getPassword());
            User responseUser = userService.register(requestedUser);
            if (responseUser != null) {
                response.put("message", "Success Register");
                response.put("data", "user id : " + responseUser.getId());
            }else{
                response.put("message", "Failed to register");
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    
}
