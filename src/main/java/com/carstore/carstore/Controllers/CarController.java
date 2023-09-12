package com.carstore.carstore.Controllers;

import com.carstore.carstore.exceptions.CarValidationError;
import com.carstore.carstore.models.Car;
import com.carstore.carstore.models.DTOs.CarDTO;
import com.carstore.carstore.services.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("{id}")
    public ResponseEntity<Object> getCarByIdChassi(@PathVariable (value = "id") Long idChassi){
        var car = carService.getCarById(idChassi);
        if(car != null){
            return ResponseEntity.status(HttpStatus.OK).body(car);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
    }
    @PostMapping("/cars")
    public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO){
        Car car = new Car();
        BeanUtils.copyProperties(carDTO, car);
        List<String> brands = Arrays.asList("Ford", "Chevrolet", "BMW", "Volvo");
        if(!brands.contains(car.getBrand())){
            CarValidationError carValidationError = new CarValidationError("Brands must be Ford, Chevrolet, BMW, or Volvo.");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(carValidationError);
        }
        carService.createCar(car);
        BeanUtils.copyProperties(car, carDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(carDTO);
    }
}
