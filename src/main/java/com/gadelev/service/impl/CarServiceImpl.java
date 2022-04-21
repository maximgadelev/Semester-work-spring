package com.gadelev.service.impl;

import com.gadelev.dto.CarDto;
import com.gadelev.dto.CreateCarDto;
import com.gadelev.dto.PassengerDto;
import com.gadelev.model.Car;
import com.gadelev.model.Passenger;
import com.gadelev.repo.CarRepository;
import com.gadelev.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDto saveCar(CreateCarDto createCarDto,Passenger passenger) {
        createCarDto.setPassenger(passenger);
        return CarDto.fromModel(carRepository.save(new Car(createCarDto.getPassenger(), createCarDto.getBrand(), createCarDto.getNumber(),createCarDto.getNumberOfPlaces(), createCarDto.getModel())));
    }
}
