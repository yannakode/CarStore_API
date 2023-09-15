package com.carstore.carstore.models.DTOs;

import com.carstore.carstore.models.Car;
import com.carstore.carstore.models.enums.ValidBrands;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CarDTO{
        @NotNull(message = "idChassi must not be null.")
        Long idChassi;
        @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces.")
        @NotEmpty(message = "Name must not be null.")
        String name;
        @NotNull
        String brand;
        @NotNull(message = "Color must not be null.")
        String color;
        @NotNull(message = "Fabrication year must not be null.")
        String fabricationYear;

        public CarDTO() {
        }

        public CarDTO(String name, String brand, String color, String fabricationYear) {
                this.name = name;
                this.brand = brand;
                this.color = color;
                this.fabricationYear = fabricationYear;
        }
        public CarDTO(Car car){
                this.name = car.getName();
                this.brand = car.getBrand();
                this.color = car.getColor();
                this.fabricationYear = car.getFabricationYear();
        }
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
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

        public Long getIdChassi() {
                return idChassi;
        }

        public void setIdChassi(Long idChassi) {
                this.idChassi = idChassi;
        }
}

