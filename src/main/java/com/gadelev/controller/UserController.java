package com.gadelev.controller;

import com.gadelev.model.Passenger;
import com.gadelev.security.CustomPassengerDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/passenger")
    public String getProfile(Model model, Authentication authentication) {
        Passenger passenger= ((CustomPassengerDetails)authentication.getPrincipal()).getPassenger();
        model.addAttribute("passenger",passenger);
        return "profilePassenger";
    }

}
