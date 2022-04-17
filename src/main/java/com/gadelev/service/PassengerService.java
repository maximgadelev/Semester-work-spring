package com.gadelev.service;

import com.gadelev.dto.CreatePassengerDto;
import com.gadelev.dto.PassengerDto;

public interface PassengerService {
    PassengerDto createNewPassenger(CreatePassengerDto createPassengerDto);
}
