package com.carstore.carstore.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "TB_CARS")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idChassi;
    @NotNull
    @Pattern(regexp = "^[A-Z][a-zA-Z]{0,9}*$", message = "Name must start with an uppercase letter and contain only letters.")
    private String name;
    @NotNull
    @Pattern(regexp = "^[A-Z][a-zA-Z]{0,9}*$", message = "Brand must start with an uppercase letter and contain only letters.")
    private String brand;
    @NotNull
    @Pattern(regexp = "^[A-Z][a-zA-Z]{0,9}*$", message = "Color must start with an uppercase letter and contain only letters.")
    private  String color;
    private String fabricationYear;

    public Long getIdChassi() {
        return idChassi;
    }

    public void setIdChassi(Long idChassi) {
        this.idChassi = idChassi;
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
}
