package com.gadelev.repo;

import com.gadelev.model.Car;
import com.gadelev.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Car getByTrips(Trip trip);
}
