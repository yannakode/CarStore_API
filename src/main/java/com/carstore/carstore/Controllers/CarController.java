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

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<CarDTO> carDTOList = carService.getAllCars();
        if(carDTOList != null && !carDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(carDTOList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List is empty or null");
    }
    @GetMapping("{id}")
    public ResponseEntity<Object> getCarByChassiId(@PathVariable (value = "id") Long idChassi){
        var car = carService.getCarById(idChassi);
        if(car.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(car.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
    }
    @PostMapping("/cars")
    public ResponseEntity<?> addCar(@RequestBody @Valid CarDTO carDTO){
        carService.createCar(carDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(carDTO);
    }
    @DeleteMapping("{id}")
    ResponseEntity<?> deleteCar(@PathVariable(value = "id") Long chassiId){
        boolean deleted = carService.deleteCar(chassiId);
        return deleted ? ResponseEntity.ok().body("Car was deleted successfully") : ResponseEntity.notFound().build();
    }
}
