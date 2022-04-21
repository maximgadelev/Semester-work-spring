package com.gadelev.dto;

import com.gadelev.model.Passenger;

public class PassengerDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private double rating;
    private String dateOfBirth;
    private String profileImage;
    private Passenger.Role role;

    public PassengerDto(Integer id, String name, String surname, String email, String password, double rating, String dateOfBirth, String profileImage,Passenger.Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.rating = rating;
        this.dateOfBirth = dateOfBirth;
        this.profileImage = profileImage;
        this.role=role;
    }

    public PassengerDto(String name, String surname, String email, String password, double rating, String dateOfBirth, String profileImage) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.rating = rating;
        this.dateOfBirth = dateOfBirth;
        this.profileImage = profileImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Passenger.Role getRole() {
        return role;
    }

    public void setRole(Passenger.Role role) {
        this.role = role;
    }

    public static PassengerDto fromModel(Passenger passenger) {
        return new PassengerDto(
                passenger.getId(),
                passenger.getName(),
                passenger.getSurname(),
                passenger.getEmail(),
                passenger.getPassword(),
                passenger.getRating(),
                passenger.getDateOfBirth(),
                passenger.getProfileImage(),
                passenger.getRole()
        );
    }
}
