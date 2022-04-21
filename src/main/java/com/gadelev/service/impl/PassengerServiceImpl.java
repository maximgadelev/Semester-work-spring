package com.gadelev.service.impl;

import com.gadelev.dto.CreatePassengerDto;
import com.gadelev.dto.PassengerDto;
import com.gadelev.model.Passenger;
import com.gadelev.repo.PassengerRepository;
import com.gadelev.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final BCryptPasswordEncoder encoder;
    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, BCryptPasswordEncoder encoder) {
        this.passengerRepository = passengerRepository;
        this.encoder = encoder;
    }

    @Override
    public PassengerDto createNewPassenger(CreatePassengerDto createPassengerDto) {
        return PassengerDto.fromModel(passengerRepository.save(new Passenger(createPassengerDto.getName(), createPassengerDto.getSurname(), createPassengerDto.getEmail(), encoder.encode(createPassengerDto.getPassword()), createPassengerDto.getDateOfBirth(),createPassengerDto.getRole())));
    }

    @Override
    public PassengerDto getPassengerByEmail(String email) {
        Optional<Passenger> passenger=passengerRepository.getByEmail(email);
        if(passenger.isPresent()) {
            return PassengerDto.fromModel(passenger.get());
        }else {
            return null;
        }
    }
}
