package com.nutrixpe.nutrixpe_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class NutritionGoals {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        private Double weight;

        @NotNull
        private Double height;

        @NotNull
        private Integer age;

        @NotNull
        private String sex;

        @lombok.Setter
        @NotNull
        @Enumerated(EnumType.STRING)
        private ActivityLevel activityLevel;
        @NotNull
        @Enumerated(EnumType.STRING)
        private NutritionGoals nutritionGoal;
    public NutritionGoals (){

    }
    public NutritionGoals(Long id, Double weight, Double height, Integer age, String sex, ActivityLevel activityLevel, NutritionGoals nutritionGoals)
    {
        this.id=id;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        this.activityLevel = activityLevel;
        this.nutritionGoal = nutritionGoal;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public NutritionGoals getNutritionGoal() {
        return nutritionGoal;
    }

    public void setNutritionGoal(NutritionGoals nutritionGoal) {
        this.nutritionGoal = nutritionGoal;
    }

}


