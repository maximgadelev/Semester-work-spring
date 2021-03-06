package com.gadelev.service;

import com.gadelev.dto.CreatePassengerDto;
import com.gadelev.dto.PassengerDto;
import com.gadelev.model.Passenger;

import java.util.List;

public interface PassengerService {
    PassengerDto createNewPassenger(CreatePassengerDto createPassengerDto);

    PassengerDto getPassengerByEmail(String email);

    void updatePhoto(Passenger passenger, String url);

    PassengerDto getByTripId(Integer id);

    List<PassengerDto> getPassengersByTripId(Integer tripId);

    PassengerDto getPassengerById(Integer id);

    List<PassengerDto> getPassengersWhoWriteFeedback(Integer passenger_id);

    Integer getRatingCount(Integer id);

    Double getRatingSum(Integer id);

    PassengerDto getNewRating(PassengerDto passenger);
}
