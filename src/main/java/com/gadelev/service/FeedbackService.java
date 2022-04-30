package com.gadelev.service;

import com.gadelev.dto.CreateFeedbackDto;
import com.gadelev.dto.FeedbackDto;
import com.gadelev.model.Passenger;

import java.util.List;

public interface FeedbackService {
   FeedbackDto creteNewFeedback(Integer passengerId,String text,Integer from_passenger_id,Integer added_rating);
   List<FeedbackDto> getFeedbacksByPassenger(Passenger passenger);
}
