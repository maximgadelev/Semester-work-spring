package com.gadelev.repo;

import com.gadelev.model.Car;
import com.gadelev.model.Passenger;
import com.gadelev.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    @Query(value = "SELECT * FROM trip where date = ?1 and time = ?2 and path =?3 and ?4<=free_places and status='on' ", nativeQuery = true)
    List<Trip> getBySearch(String date, String time, String path, int freePlaces);
    List<Trip> getTripsByPassengersAndStatus(Passenger passenger, String status);
    @Query(value = "select t.id,date,free_places,not_free_places,path,status,time,t.car_id,price from (select p.id,c.id as car_id  from passengers p inner join car c on p.id = c.driver_id) as driver_car  inner join trip t on t.car_id=driver_car.car_id where status = ? and driver_car.id= ?",nativeQuery = true)
    List<Trip> getTripsByPassengersAndStatusAndCar(String status,Integer id);

    Trip getById(Integer tripId);
}
