package com.rental.car_rental.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(Long id) {
        super("Nie znaleziono auta o id: " + id);
    }
}