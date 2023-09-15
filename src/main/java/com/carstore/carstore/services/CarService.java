package com.carstore.carstore.services;

import com.carstore.carstore.models.Car;
import com.carstore.carstore.models.DTOs.CarDTO;
import com.carstore.carstore.repository.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Transactional
    public CarDTO saveCar(CarDTO carDTO){
        Car car = new Car();
        BeanUtils.copyProperties(carDTO, car);
        carRepository.save(car);
        BeanUtils.copyProperties(car, carDTO);
        return carDTO;
    }

    @Transactional(readOnly = true)
    public Optional<CarDTO> getCarById(Long chassi){
        Optional<Car> carOp = carRepository.findById(chassi);
        if(carOp.isPresent()){
            Car car = carOp.get();
            CarDTO carDTO = new CarDTO();
            BeanUtils.copyProperties(car, carDTO);
            return Optional.of(carDTO);
        }else{
            return Optional.empty();
        }
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
    public boolean validBrand(String brand){
        List<String> brands = Arrays.asList("Ford", "Chevrolet", "Volvo", "BMW");
        return brands.contains(brand);
    }
}
