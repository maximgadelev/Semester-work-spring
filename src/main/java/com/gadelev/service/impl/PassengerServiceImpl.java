package com.gadelev.service.impl;

import com.gadelev.dto.CreatePassengerDto;
import com.gadelev.dto.PassengerDto;
import com.gadelev.model.Car;
import com.gadelev.model.Passenger;
import com.gadelev.model.Trip;
import com.gadelev.repo.CarRepository;
import com.gadelev.repo.PassengerRepository;
import com.gadelev.repo.TripRepository;
import com.gadelev.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final CarRepository carRepository;
    private final TripRepository tripRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, CarRepository carRepository, TripRepository tripRepository, BCryptPasswordEncoder encoder) {
        this.passengerRepository = passengerRepository;
        this.carRepository = carRepository;
        this.tripRepository = tripRepository;
        this.encoder = encoder;
    }

    @Override
    public PassengerDto createNewPassenger(CreatePassengerDto createPassengerDto) {
        return PassengerDto.fromModel(passengerRepository.save(new Passenger(createPassengerDto.getName(), createPassengerDto.getSurname(), createPassengerDto.getEmail(), encoder.encode(createPassengerDto.getPassword()), createPassengerDto.getDateOfBirth(), createPassengerDto.getRole())));
    }

    @Override
    public PassengerDto getPassengerByEmail(String email) {
        Optional<Passenger> passenger = passengerRepository.getByEmail(email);
        if (passenger.isPresent()) {
            return PassengerDto.fromModel(passenger.get());
        } else {
            return null;
        }
    }

    @Override
    public void updatePhoto(Passenger passenger, String url) {
        passenger.setProfileImage(url);
        passengerRepository.save(passenger);
    }

    @Override
    public PassengerDto getByTripId(Integer tripId) {
        Trip trip1 = tripRepository.getById(tripId);
        Car car = carRepository.getByTrips(trip1);
        Passenger passenger = passengerRepository.getByCar(car.getId()).get();
        return PassengerDto.fromModel(passenger);
    }

    @Override
    public List<PassengerDto> getPassengersByTripId(Integer tripId) {
        Trip trip = tripRepository.getById(tripId);
       List<Passenger> passengers = passengerRepository.getPassengersByPassengerTrips(trip);
        System.out.println(passengers.size());
       List<PassengerDto> passengerDtos=new ArrayList<>();
        for (Passenger passenger:passengers
             ) {
            passengerDtos.add(PassengerDto.fromModel(passenger));
        }
        return passengerDtos;
    }
}
