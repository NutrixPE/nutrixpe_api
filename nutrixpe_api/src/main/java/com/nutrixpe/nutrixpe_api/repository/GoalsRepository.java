package com.nutrixpe.nutrixpe_api.repository;

import com.nutrixpe.nutrixpe_api.model.NutritionGoals;

import java.util.Optional;

public interface GoalsRepository {
        NutritionGoals save(NutritionGoals nutritionGoals);
        Optional<NutritionGoals> findByUserId(Long userId);
        void deleteByUserId(Long userId);
    }


