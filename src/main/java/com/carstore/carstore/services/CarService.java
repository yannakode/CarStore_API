package com.carstore.carstore.services;

import com.carstore.carstore.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.carstore.carstore.repository.CarRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public boolean brandValidation(String brand){
        List<String> brands = Arrays.asList("Ford", "Chevrolet", "BMW", "Volvo");
        return brands.contains(brand);
    }

    public Car createCar(Car car){
        return carRepository.save(car);
    }

    public Optional<Car> getCarById(Long chassi){
        return carRepository.findById(chassi);
    }
}
