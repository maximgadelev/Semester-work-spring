package com.gadelev.service;

import com.gadelev.dto.CreateFeedbackDto;
import com.gadelev.dto.FeedbackDto;

public interface FeedbackService {
    FeedbackDto creteNewFeedback(CreateFeedbackDto createFeedbackDto);
}
