package com.gadelev.service.impl;

import com.gadelev.dto.CreateTripDto;
import com.gadelev.dto.TripDto;
import com.gadelev.model.Trip;
import com.gadelev.repo.TripRepository;
import com.gadelev.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public TripDto saveTrip(CreateTripDto createTripDto) {
        return TripDto.fromModel(tripRepository.save(new Trip(createTripDto.getCar(), createTripDto.getDate(), createTripDto.getPrice(), createTripDto.getPath(), createTripDto.getTime(), createTripDto.getFreePlaces())));
    }

    @Override
    public List<TripDto> getBySearch(String date, String time, String path, int freePlaces) {
        List<Trip> tripList = tripRepository.getBySearch(date, time, path, freePlaces);
        return tripList.stream().map(trip -> new TripDto(
                        trip.getId(),
                        trip.getCar(),
                        trip.getDate(),
                        trip.getPrice(),
                        trip.getPath(),
                        trip.getTime(),
                        trip.getFreePlaces(),
                        trip.getNotFreePlaces(),
                        trip.getStatus()
                )
        ).collect(Collectors.toList());
    }
}
