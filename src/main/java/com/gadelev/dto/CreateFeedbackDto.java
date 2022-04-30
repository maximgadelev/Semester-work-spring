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
public class CreateFeedbackDto {
    private String text;
    Passenger passenger;
    Integer from_passenger_id;
    private int added_rating;
}
