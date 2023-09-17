package com.carstore.carstore.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "TB_CARS")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long chassiId;

    private String model;

    private String brand;

    private  String color;
    private String fabricationYear;

    public Long getChassiId() {
        return chassiId;
    }

    public void setChassiId(Long chassiId) {
        this.chassiId = chassiId;
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
