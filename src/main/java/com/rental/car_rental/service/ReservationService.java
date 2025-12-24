package com.rental.car_rental.service;

import org.springframework.stereotype.Service;
import lombok.*;

import com.rental.car_rental.dto.ReservationRequest;
import com.rental.car_rental.model.Car;
import com.rental.car_rental.model.Reservation;
import com.rental.car_rental.repository.CarRepository;
import com.rental.car_rental.repository.ReservationRepository;

@Service
@RequiredArgsConstructor
public class ReservationService {
    
    private final ReservationRepository reservationRepository;
    private final CarRepository carRepository;

    public Long makeReservation(ReservationRequest request) {
        Car car = carRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("no car found"));
        boolean isOccupied = reservationRepository.existsOverlappingReservation(
                request.getId(), 
                request.getStartTime(),
                request.getEndTime()
        );

        if (isOccupied) {
            throw new IllegalStateException("Auto jest już zarezerwowane w tym terminie!");
        }

        Reservation reservation = Reservation.builder()
            .startTime(request.getStartTime())
            .endTime(request.getEndTime())
            .car(car)
            .build();
        Reservation savedReservation = reservationRepository.save(reservation);
        return savedReservation.getId();
    }
}
