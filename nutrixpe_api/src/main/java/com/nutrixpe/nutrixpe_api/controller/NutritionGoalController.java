package com.nutrixpe.nutrixpe_api.controller;

import com.nutrixpe.nutrixpe_api.model.NutritionGoals;
import com.nutrixpe.nutrixpe_api.service.impl.GoalsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nutrition-goals")
public class NutritionGoalController {
        @Autowired
        private GoalsService goalsService;
        @PostMapping
        public ResponseEntity<Object> CreateNutritionalGoals(@RequestBody @Valid NutritionGoals nutritionGoals, BindingResult result) {
            if (result.hasErrors()) {
                List<String> errors = new ArrayList<>();
                for (FieldError error : result.getFieldErrors()) {
                    errors.add(error.getField() + ": " + error.getDefaultMessage());
                }
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }
            goalsService.saveNutritionalGoals(nutritionGoals);
            return new ResponseEntity<>("Objetivos nutricionales creados correctamente.", HttpStatus.CREATED);
        }

    }

