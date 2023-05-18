package com.nutrixpe.nutrixpe_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
@Table(name = "activity_level")
    public class ActivityLevel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        private String name;

        @NotBlank
        private String description;

        @DecimalMin("1.0")
        @DecimalMax("2.5")
        private BigDecimal activityFactor;
        public ActivityLevel() {}

        public ActivityLevel(String name, String description, BigDecimal activityFactor) {
            this.name = name;
            this.description = description;
            this.activityFactor = activityFactor;
        }

        // Getters y Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public BigDecimal getActivityFactor() {
            return activityFactor;
        }

        public void setActivityFactor(BigDecimal activityFactor) {
            this.activityFactor = activityFactor;
        }
        @Override
        public String toString() {
            return "ActivityLevel{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", activityFactor=" + activityFactor +
                    '}';
        }
    }


