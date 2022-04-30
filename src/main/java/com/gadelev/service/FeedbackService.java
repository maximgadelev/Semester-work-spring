package com.gadelev.service;

import com.gadelev.dto.CreateFeedbackDto;
import com.gadelev.dto.FeedbackDto;

public interface FeedbackService {
   FeedbackDto creteNewFeedback(Integer passengerId,String text,Integer from_passenger_id,Integer added_rating);
}
