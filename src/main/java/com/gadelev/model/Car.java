package com.gadelev.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "driver_id")
    private Passenger passenger;
    private String brand;
    private String number;
    private int numberOfPlaces;
    private String model;

    public Car(Passenger passenger, String brand, String number, int numberOfPlaces, String model) {
        this.passenger = passenger;
        this.brand = brand;
        this.number = number;
        this.numberOfPlaces = numberOfPlaces;
        this.model = model;
    }
}
