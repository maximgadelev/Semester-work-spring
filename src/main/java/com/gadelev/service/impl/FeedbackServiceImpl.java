package com.gadelev.service.impl;

import com.gadelev.dto.FeedbackDto;
import com.gadelev.model.Feedback;
import com.gadelev.repo.FeedbackRepository;
import com.gadelev.repo.PassengerRepository;
import com.gadelev.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;
private final PassengerRepository passengerRepository;
    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, PassengerRepository passengerRepository) {
        this.feedbackRepository = feedbackRepository;
        this.passengerRepository = passengerRepository;
    }

    @Override
    public FeedbackDto creteNewFeedback(Integer passengerId,String text,Integer from_passenger_id,Integer added_rating) {
            return FeedbackDto.fromModel(feedbackRepository.save(new Feedback(passengerRepository.getPassengersById(passengerId),text,from_passenger_id,added_rating)));
    }
}
