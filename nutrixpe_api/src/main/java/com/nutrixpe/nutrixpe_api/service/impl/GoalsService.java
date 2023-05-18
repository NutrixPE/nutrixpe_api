package com.nutrixpe.nutrixpe_api.service.impl;

import com.nutrixpe.nutrixpe_api.exception.OutofRangeException;
import com.nutrixpe.nutrixpe_api.model.NutritionGoals;
import com.nutrixpe.nutrixpe_api.repository.GoalsRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class GoalsService {
    @Autowired
    private GoalsRepository goalsRepository;
        public void saveNutritionalGoals(NutritionGoals nutritionGoals) {
            validateNutritionGoals(nutritionGoals);
            goalsRepository.save(nutritionGoals);
        }
        public boolean validateNutritionGoals(NutritionGoals nutritionGoal) {
            // Check if all required fields are present
            if (nutritionGoal.getAge() == null || nutritionGoal.getSex() == null
                    || nutritionGoal.getHeight() == null || nutritionGoal.getWeight() == null
                    || nutritionGoal.getActivityLevel() == null || nutritionGoal.getNutritionGoal() == null) {
               throw new OutofRangeException("El valor esta fuera del rango");
            }

            // Check if age is within acceptable range
            if (nutritionGoal.getAge() < 18 || nutritionGoal.getAge() > 99) {
                throw new OutofRangeException("El valor esta fuera del rango");

            }

            // Check if height is within acceptable range
            if (nutritionGoal.getHeight() < 120 || nutritionGoal.getHeight() > 220) {
                throw new OutofRangeException("El valor esta fuera del rango");

            }

            // Check if weight is within acceptable range
            if (nutritionGoal.getWeight() < 30 || nutritionGoal.getWeight() > 300) {
                throw new OutofRangeException("El valor esta fuera del rango");

            }


            return true;
        }
    }


