package com.gadelev.repo;

import com.gadelev.model.Feedback;
import com.gadelev.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
    List<Feedback> getFeedbacksByPassenger(Passenger passenger);
}
