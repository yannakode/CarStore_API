package com.carstore.carstore.Controllers;

import com.carstore.carstore.models.DTOs.CarDTO;
import com.carstore.carstore.services.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Object> getCarByChassiId(@PathVariable (value = "id") Long chassiId){
        var car = carService.getCarById(chassiId);
        if(car.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(car.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
    }

    @PostMapping("/cars")
    public ResponseEntity<?> addCar(@RequestBody @Valid CarDTO carDTO) {
        if(!carService.validBrand(carDTO.getBrand())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid brand value. Only Chevrolet, Volvo, BMW, and Ford are accepted");
        }
        carService.saveCar(carDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(carDTO);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<?> updateCar(@PathVariable (value = "id") Long id, @RequestBody @Valid CarDTO carDTO){
        if(!carService.validBrand(carDTO.getBrand())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid brand value. Only Chevrolet, Volvo, BMW, and Ford are accepted");
        }
        var existingCarId = carService.updateCar(id, carDTO);
        if(existingCarId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found. Send a valid chassiId");
        }
        return ResponseEntity.status(HttpStatus.OK).body(carDTO);
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteCar(@PathVariable(value = "id") Long chassiId){
        boolean deleted = carService.deleteCar(chassiId);
        return deleted ? ResponseEntity.ok().body("Car was deleted successfully") : ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Car with chassiId " + chassiId + " not found");
    }
}
