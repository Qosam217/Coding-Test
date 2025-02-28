package com.example.coding_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coding_test.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);
    
    boolean existsByUsername(String username);
    
}
