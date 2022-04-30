package com.gadelev.dto;

import com.gadelev.model.Feedback;
import com.gadelev.model.Passenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackDto {
    private Integer id;
    Passenger passenger;
    String text;
    Integer from_passenger_id;
    int added_rating;

    public static FeedbackDto fromModel(Feedback feedback) {
        return new FeedbackDto(
                feedback.getId(),
                feedback.getPassenger(),
                feedback.getText(),
                feedback.getFrom_passenger_id(),
                feedback.getAdded_rating()
        );
    }
}
