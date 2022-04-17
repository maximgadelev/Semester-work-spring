package com.gadelev.controller;

import com.gadelev.dto.CreatePassengerDto;
import com.gadelev.dto.PassengerDto;
import com.gadelev.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RegistrationController {
    private final PassengerService passengerService;

    @Autowired
    public RegistrationController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }


    @GetMapping("/reg")
    public String getLoginPage(Model model) {
        model.addAttribute("passenger", new CreatePassengerDto());
        return "regiistration";
    }

    @PostMapping("/reg")
    public String userRegistration(CreatePassengerDto createUserDto) {
        PassengerDto passengerDto=passengerService.getPassengerByEmail(createUserDto.getEmail());
        if(passengerDto==null) {
            passengerService.createNewPassenger(createUserDto);
            return "redirect:/login";
        }else{
            System.out.println("пароль уже существует");
            return "regiistration";
        }
    }
}

