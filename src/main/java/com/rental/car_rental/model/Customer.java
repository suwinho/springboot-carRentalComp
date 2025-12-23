package com.rental.car_rental.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    
    private String lastName;

    private String email; 

    private String address;

    private LocalDate birthDate; 

    @OneToMany(mappedBy = "customer") 
    private List<Reservation> reservations = new ArrayList<>();
}
