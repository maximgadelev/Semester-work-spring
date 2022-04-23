package com.gadelev.service;

import com.gadelev.dto.CreateTripDto;
import com.gadelev.dto.TripDto;


import java.util.List;

public interface TripService {
    TripDto saveTrip(CreateTripDto createTripDto);
    List<TripDto> getBySearch(String date, String time, String path, int freePlaces);
    TripDto getTrip(Integer tripId,Integer places,String email);
}
