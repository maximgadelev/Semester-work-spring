package com.gadelev.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    private String date;
    private Integer price;
    private String path;
    private String time;
    private Integer freePlaces;
    private Integer notFreePlaces = 0;
    private String status = "on";
    @ManyToMany(mappedBy = "passengerTrips")
    List<Passenger> passengers;

    public Trip(Car car, String date, Integer price, String path, String time, Integer freePlaces) {
        this.car = car;
        this.date = date;
        this.price = price;
        this.path = path;
        this.time = time;
        this.freePlaces = freePlaces;
    }
}
