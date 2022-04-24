package com.gadelev.service;

import com.gadelev.dto.CreatePassengerDto;
import com.gadelev.dto.PassengerDto;
import com.gadelev.model.Passenger;
import com.gadelev.model.Trip;

public interface PassengerService {
    PassengerDto createNewPassenger(CreatePassengerDto createPassengerDto);
    PassengerDto getPassengerByEmail(String email);
    void updatePhoto(Passenger passenger,String url);
    PassengerDto getByTripId(Integer id);
}
