package com.rental.car_rental.dto;

import java.math.BigDecimal;

import lombok.*;

@Getter @Setter
public class CarRequest {
    public String brand;
    public String model;
    public BigDecimal basePrice;

}
