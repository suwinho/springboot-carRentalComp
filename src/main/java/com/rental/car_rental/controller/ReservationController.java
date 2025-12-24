package com.rental.car_rental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.rental.car_rental.dto.ReservationRequest;
import com.rental.car_rental.service.ReservationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Long> createReservation(@RequestBody ReservationRequest request) {
        Long reservationId = reservationService.makeReservation(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationId);
    }
}
