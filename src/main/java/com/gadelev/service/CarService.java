package com.gadelev.service;

import com.gadelev.dto.CarDto;
import com.gadelev.dto.CreateCarDto;
import com.gadelev.model.Passenger;

public interface CarService {
    CarDto saveCar(CreateCarDto createCarDto, Passenger passenger);
}
