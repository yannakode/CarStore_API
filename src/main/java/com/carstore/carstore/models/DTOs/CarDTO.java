package com.carstore.carstore.models.DTOs;

import com.carstore.carstore.models.Car;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CarDTO{
        @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces.")
        @NotEmpty(message = "Model must not be null.")
        String model;
        @NotNull(message = "brand must not be null.")
        String brand;
        @NotNull(message = "Color must not be null.")
        String color;
        @NotNull(message = "Fabrication year must not be null.")
        String fabricationYear;

        public CarDTO() {
        }

        public CarDTO(String model, String brand, String color, String fabricationYear) {
                this.model = model;
                this.brand = brand;
                this.color = color;
                this.fabricationYear = fabricationYear;
        }
        public CarDTO(Car car){
                this.model = car.getModel();
                this.brand = car.getBrand();
                this.color = car.getColor();
                this.fabricationYear = car.getFabricationYear();
        }

        public String getModel() {
                return model;
        }

        public void setModel(String model) {
                this.model = model;
        }

        public String getBrand() {
                return brand;
        }

        public void setBrand(String brand) {
                this.brand = brand;
        }

        public String getColor() {
                return color;
        }

        public void setColor(String color) {
                this.color = color;
        }

        public String getFabricationYear() {
                return fabricationYear;
        }

        public void setFabricationYear(String fabricationYear) {
                this.fabricationYear = fabricationYear;
        }
}

