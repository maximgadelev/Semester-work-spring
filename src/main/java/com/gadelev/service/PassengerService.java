package com.gadelev.service;

import com.gadelev.dto.CreatePassengerDto;
import com.gadelev.dto.PassengerDto;
import com.gadelev.model.Passenger;

public interface PassengerService {
    PassengerDto createNewPassenger(CreatePassengerDto createPassengerDto);
    PassengerDto getPassengerByEmail(String email);
}
