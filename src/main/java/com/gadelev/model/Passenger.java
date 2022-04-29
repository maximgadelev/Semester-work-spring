package com.gadelev.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "passengers")
public class Passenger {
    public enum Role {
        PASSENGER, DRIVER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    @Size(min = 8, max = 64, message = "Email should contains from 8 to 64 symbols")
    @Column(nullable = false, length = 64, unique = true)
    private String email;
    @Size(min = 8, max = 64, message = "Password should contains from 8 to 64 symbols")
    @Column(nullable = false, length = 64)
    private String password;
    @ManyToMany
    @JoinTable(
            name = "passengers_trip",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "trip__id"))
    List<Trip> passengerTrips;

    private double rating = 5.0;
    private String dateOfBirth;
    private String profileImage = "https://res.cloudinary.com/itis-gadelev/image/upload/v1635691243/default_user_bcaf0n.png";

    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(mappedBy = "passenger", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Car car;
    public Passenger(String name, String surname, String email, String password, String dateOfBirth, Role role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
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

    public List<Trip> getPassengerTrips() {
        return passengerTrips;
    }

    public void setPassengerTrips(List<Trip> passengerTrips) {
        this.passengerTrips = passengerTrips;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passengerTrips=" + passengerTrips +
                ", rating=" + rating +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", role=" + role +
                ", car=" + car +
                '}';
    }
}

