package com.gadelev.service.impl;

import com.gadelev.dto.CreateTripDto;
import com.gadelev.dto.TripDto;
import com.gadelev.model.Trip;
import com.gadelev.repo.TripRepository;
import com.gadelev.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public TripDto saveTrip(CreateTripDto createTripDto) {
        return TripDto.fromModel(tripRepository.save(new Trip(createTripDto.getCar(),createTripDto.getDate(),createTripDto.getPrice(),createTripDto.getPath(),createTripDto.getTime(),createTripDto.getFreePlaces())));
    }
}
