package com.gadelev.dto;

import com.gadelev.model.Passenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCarDto {
    private String brand;
    private String number;
    private int numberOfPlaces;
    private String model;
    private Passenger passenger;

}
