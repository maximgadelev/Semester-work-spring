package com.gadelev.dto;

import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
public class CreatePassengerDto {
    @NotBlank(message = "Name shouldn't be blank!")
    private String name;
    @NotBlank(message = "Surname shouldn't be blank!")
    private String surname;
    @NotBlank(message = "Email shouldn't be blank!")
    @Email
    private String email;
    @NotBlank(message = "Password shouldn't be blank!")
    private String password;
    @NotBlank(message = "Date of birth shouldn't be blank!")
    private String dateOfBirth;


    public CreatePassengerDto(String name, String surname, String email, String password, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
