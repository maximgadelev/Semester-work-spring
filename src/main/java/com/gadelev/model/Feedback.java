package com.gadelev.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    Passenger passenger;
    String text;
    Integer from_passenger_id;
    Integer added_rating;

    public Feedback(Passenger passenger, String text, Integer from_passenger_id, Integer added_rating) {
        this.passenger = passenger;
        this.text = text;
        this.from_passenger_id = from_passenger_id;
        this.added_rating = added_rating;
    }
}
