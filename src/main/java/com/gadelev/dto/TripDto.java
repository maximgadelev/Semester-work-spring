package com.gadelev.dto;

import com.gadelev.model.Car;
import com.gadelev.model.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripDto {
    private Integer id;
    private Car car;
    private String date;
    private Integer price;
    private String path;
    private String time;
    private Integer freePlaces;
    private Integer notFreePlaces;
    private String status;

    public static TripDto fromModel(Trip trip) {
        return new TripDto(
                trip.getId(),
                trip.getCar(),
                trip.getDate(),
                trip.getPrice(),
                trip.getPath(),
                trip.getTime(),
                trip.getFreePlaces(),
                trip.getNotFreePlaces(),
                trip.getStatus()
        );
    }
}
