package com.gadelev.controller;

import com.gadelev.model.Passenger;
import com.gadelev.security.CustomPassengerDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @GetMapping("/main")
    public String getMainPage(Authentication authentication, Model model){
        if(authentication!=null) {
            List<String> roles = authentication.getAuthorities().stream()
                    .map(r -> r.getAuthority()).collect(Collectors.toList());
            model.addAttribute("user", roles.get(0));
            Passenger passenger = ((CustomPassengerDetails) authentication.getPrincipal()).getPassenger();
            model.addAttribute("car",passenger.getCar());
            return "main";
        }
        model.addAttribute("user","anon");
        return "main";
    }
}
