package com.gadelev.service;

import com.gadelev.dto.CreateTripDto;
import com.gadelev.dto.TripDto;

public interface TripService {
    TripDto saveTrip(CreateTripDto createTripDto);
}
