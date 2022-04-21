package com.gadelev.dto;

import com.gadelev.model.Car;
import com.gadelev.model.Passenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {
    private Integer id;
    private Passenger passenger;
    private String brand;
    private String number;
    private int numberOfPlaces;
    private String model;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public static CarDto fromModel(Car car){
        return new CarDto(
                car.getId(),
                car.getPassenger(),
                car.getBrand(),
                car.getNumber(),
                car.getNumberOfPlaces(),
                car.getModel()
        );
    }
}
