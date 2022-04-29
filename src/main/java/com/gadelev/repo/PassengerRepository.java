package com.gadelev.repo;

import com.gadelev.model.Car;
import com.gadelev.model.Passenger;
import com.gadelev.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    Optional<Passenger> getByEmail(String email);
    @Query(value = "select * from passengers inner join car c on passengers.id = c.driver_id where c.id= ?1",nativeQuery = true)
    Optional<Passenger> getByCar(Integer carId);
    List<Passenger> getPassengersByPassengerTrips(Trip trip);

}
