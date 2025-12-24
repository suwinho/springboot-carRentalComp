package com.rental.car_rental.service;

import com.rental.car_rental.dto.CarRequest;
import com.rental.car_rental.exception.CarNotFoundException;
import com.rental.car_rental.model.Car;
import com.rental.car_rental.model.CarStatus;
import com.rental.car_rental.repository.CarRepository;
import org.springframework.stereotype.Service;
import lombok.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    
    public long addCar(CarRequest request) {
        Car car = Car.builder()
                        .brand(request.getBrand())
                        .model(request.getModel())
                        .basePrice(request.getBasePrice())
                        .status(CarStatus.AVAILABLE)
                        .build();
        Car savedCar = carRepository.save(car);
        return savedCar.getId();
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new CarNotFoundException(id);
        }
        carRepository.deleteById(id);
    }
    
}
