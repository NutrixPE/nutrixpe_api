package com.nutrixpe.nutrixpe_api.controller;

import com.nutrixpe.nutrixpe_api.model.User;
import com.nutrixpe.nutrixpe_api.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
        private UserRepository userRepository;

        @GetMapping
        public List<User> getUsers() {
            return userRepository.findAll();
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public User createUser(@Valid @RequestBody User user) {
            return userRepository.save(user);
        }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceAccessException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceAccessException("User not found with id: " + userId));
        return ResponseEntity.ok().body(user);
    }

        @PutMapping("/{id}")
        public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                               @Valid @RequestBody User userDetails) throws ResourceAccessException {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceAccessException ("User not found with id: " + userId));

            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());

            final User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);


            }


        @DeleteMapping("/{id}")
        public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
                throws ConfigDataResourceNotFoundException{
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceAccessException("User not found with id: " + userId));

            userRepository.delete(user);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }
    }


