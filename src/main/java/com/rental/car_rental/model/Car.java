package com.rental.car_rental.model;

import jakarta.persistence.*;
import lombok.*; 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
@Getter @Setter           
@NoArgsConstructor        
@AllArgsConstructor       
@Builder                  
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private BigDecimal basePrice;

    @Enumerated(EnumType.STRING) 
    @Column(nullable = false)
    private CarStatus status;

    @Version
    private Long version;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    @Builder.Default 
    private List<Reservation> reservations = new ArrayList<>();
}
