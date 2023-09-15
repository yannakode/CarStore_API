package com.carstore.carstore.services;

import com.carstore.carstore.models.Car;
import com.carstore.carstore.models.DTOs.CarDTO;
import com.carstore.carstore.repository.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Transactional
    public CarDTO createCar(CarDTO carDTO){
        Car car = new Car();
        BeanUtils.copyProperties(carDTO, car);
        carRepository.save(car);
        BeanUtils.copyProperties(car, carDTO);
        return carDTO;
    }

    @Transactional(readOnly = true)
    public Optional<CarDTO> getCarById(Long chassi){
        Optional<Car> carOp = carRepository.findById(chassi);
        Car car = carOp.get();
        CarDTO carDTO = new CarDTO();
        BeanUtils.copyProperties(car, carDTO);
        return Optional.of(carDTO);
    }

    @Transactional(readOnly = true)
    public List<CarDTO> getAllCars(){
        List<Car> car = carRepository.findAll();
        return car.stream().map(CarDTO::new).collect(Collectors.toList());
    }
    @Transactional
    public boolean deleteCar(Long chassiId){
        if(!carRepository.existsById(chassiId)){
            return false;
        }
        carRepository.deleteById(chassiId);
        return true;
    }
}
