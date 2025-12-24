package com.rental.car_rental.dto;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Getter @Setter 
public class ReservationRequest {
    private Long id;
    @DateTimeFormat
    private LocalDateTime startTime;
    @DateTimeFormat
    private LocalDateTime endTime;
}
