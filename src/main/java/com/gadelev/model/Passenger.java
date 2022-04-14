package com.gadelev.model;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    @Size(min = 8, max = 64, message = "Password should contains from 8 to 64 symbols")
    @Column(nullable = false, length = 64)
    private String password;

    @Size(min = 8, max = 64, message = "Login should contains from 8 to 64 symbols")
    @Column(nullable = false, length = 64)
    private String login;
    private double rating;
    private String dateOfBirth;
    private String profileImage;

    public Passenger(String name, String surname, String login, String password, String dateOfBirth, Double rating) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.rating = rating;

    }

    public Passenger(String name, String surname, String login, String password, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public Passenger(int id, String name, String surname, String login, String password, double rating, String dateOfBirth, String profileImage) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.rating = rating;
        this.dateOfBirth = dateOfBirth;
        this.profileImage = profileImage;
    }

    public Passenger(String name, String surname, String login, String password, String dateOfBirth, String profileImage) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.profileImage = profileImage;
    }

    public Passenger() {

    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
}

