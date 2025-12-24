package com.rental.car_rental.controller;

import com.rental.car_rental.dto.CarRequest;
import com.rental.car_rental.model.Car;
import com.rental.car_rental.service.CarService;
import lombok.RequiredArgsConstructor;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping
    public ResponseEntity<Long> createCar(@RequestBody CarRequest carRequest) {
        Long id = carService.addCar(carRequest);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
    
    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
    
}
