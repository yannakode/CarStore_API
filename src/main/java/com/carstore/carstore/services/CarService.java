package com.carstore.carstore.services;

import com.carstore.carstore.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.carstore.carstore.repository.CarRepository;

import java.util.Optional;

@Component
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car createCar(Car car){
        return carRepository.save(car);
    }

    public Car getCarById(Long chassi){
        Optional<Car> opCar = carRepository.findById(chassi);
        return opCar.get();
    }
}
