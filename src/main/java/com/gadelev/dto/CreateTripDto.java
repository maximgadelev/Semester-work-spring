package com.gadelev.dto;

import com.gadelev.model.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTripDto {
    private String date;
    private Integer price;
    private String path;
    private String time;
    private Car car;
    private Integer freePlaces;

}
