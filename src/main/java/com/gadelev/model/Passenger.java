package com.gadelev.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;


@Entity
@Data
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
}

