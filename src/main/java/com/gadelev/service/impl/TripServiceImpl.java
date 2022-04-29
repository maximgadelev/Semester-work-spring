package com.gadelev.service.impl;

import com.gadelev.dto.CreateTripDto;
import com.gadelev.dto.TripDto;
import com.gadelev.model.Passenger;
import com.gadelev.model.Trip;
import com.gadelev.repo.PassengerRepository;
import com.gadelev.repo.TripRepository;
import com.gadelev.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    private final PassengerRepository passengerRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository, PassengerRepository passengerRepository) {
        this.tripRepository = tripRepository;
        this.passengerRepository = passengerRepository;
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

    @Override
    public TripDto getTrip(Integer tripId, Integer places, String email) {
        Trip trip = tripRepository.getById(tripId);
        trip.setFreePlaces(trip.getFreePlaces() - places);
        trip.setNotFreePlaces(trip.getNotFreePlaces() + places);
        tripRepository.save(trip);
        Passenger passenger = passengerRepository.getByEmail(email).get();
        passenger.getPassengerTrips().add(trip);
        passengerRepository.save(passenger);
        return TripDto.fromModel(trip);
    }

    @Override
    public List<TripDto> getActiveTripByPassenger(Passenger passenger) {
        List<Trip> trips = tripRepository.getTripsByPassengersAndStatus(passenger, "on");
        return trips.stream().map(trip -> new TripDto(
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

    @Override
    public List<TripDto> getEndTripBPassenger(Passenger passenger) {
        List<Trip> trips = tripRepository.getTripsByPassengersAndStatus(passenger, "off");
        return trips.stream().map(trip -> new TripDto(
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
