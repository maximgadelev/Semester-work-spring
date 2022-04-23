package com.gadelev.repo;

import com.gadelev.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    Optional<Passenger> getByEmail(String email);


}
