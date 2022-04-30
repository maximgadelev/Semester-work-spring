package com.gadelev.service.impl;

import com.gadelev.dto.CreateFeedbackDto;
import com.gadelev.dto.FeedbackDto;
import com.gadelev.model.Feedback;
import com.gadelev.repo.FeedbackRepository;
import com.gadelev.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public FeedbackDto creteNewFeedback(CreateFeedbackDto createFeedbackDto) {
        return FeedbackDto.fromModel(feedbackRepository.save(new Feedback(createFeedbackDto.getPassenger(),createFeedbackDto.getText(),createFeedbackDto.getFrom_passenger_id(),createFeedbackDto.getAdded_rating())));
    }
}
