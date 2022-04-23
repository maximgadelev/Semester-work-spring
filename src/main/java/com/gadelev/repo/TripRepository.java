package com.gadelev.repo;

import com.gadelev.dto.TripDto;
import com.gadelev.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    @Query(value = "SELECT * FROM trip where date = ?1 and time = ?2 and path =?3 and ?4<=free_places and status='on' ", nativeQuery = true)
    List<Trip> getBySearch(String date, String time, String path, int freePlaces);

}
