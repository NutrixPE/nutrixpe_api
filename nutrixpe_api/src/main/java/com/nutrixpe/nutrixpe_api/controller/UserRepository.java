package com.nutrixpe.nutrixpe_api.controller;

import com.nutrixpe.nutrixpe_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);

            Optional<User> findByEmailAndPassword(String email, String password);
        }




