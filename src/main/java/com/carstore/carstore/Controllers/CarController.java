package com.carstore.carstore.Controllers;

import com.carstore.carstore.models.Car;
import com.carstore.carstore.models.DTOs.CarDTO;
import com.carstore.carstore.services.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.InvalidPropertyException;
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
        if(car.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(car.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
    }
    @PostMapping("/cars")
    public ResponseEntity<?> addCar(@RequestBody @Valid CarDTO carDTO){
            Car car = new Car();
            BeanUtils.copyProperties(carDTO, car);
            carService.createCar(car);
            BeanUtils.copyProperties(car, carDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(carDTO);
    }
}
