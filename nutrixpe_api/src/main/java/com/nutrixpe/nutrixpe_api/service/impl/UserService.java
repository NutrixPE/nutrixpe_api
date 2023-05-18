package com.nutrixpe.nutrixpe_api.service.impl;

import com.nutrixpe.nutrixpe_api.controller.UserRepository;
import com.nutrixpe.nutrixpe_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new RuntimeException("Invalid email or password");


        }
        return user;
    }
}

