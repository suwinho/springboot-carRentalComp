package com.rental.car_rental.service;

import com.rental.car_rental.repository.CarRepository;
import org.springframework.stereotype.Service;
import lombok.*;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    
    
}
