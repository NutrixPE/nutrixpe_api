package com.nutrixpe.nutrixpe_api.controller;

import com.nutrixpe.nutrixpe_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);
    }


