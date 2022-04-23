package com.gadelev.controller;

import com.gadelev.dto.TripDto;
import com.gadelev.model.Passenger;
import com.gadelev.security.CustomPassengerDetails;
import com.gadelev.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class TripController {
    public final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/findTrips")
    public String findTrips(HttpServletRequest request, HttpServletResponse response) {
        String from = request.getParameter("first");
        String to = request.getParameter("second");
        String path = from + "-" + to;
        List<TripDto> tripDtoList = tripService.getBySearch(request.getParameter("date"), request.getParameter("time"), path, Integer.parseInt(request.getParameter("places")));
        System.out.println(tripDtoList.size());
        Cookie cookie = new Cookie("places", request.getParameter("places"));
        request.getSession().setAttribute("trips", tripDtoList);
        response.addCookie(cookie);
        return "redirect:/showTrips";
    }

    @GetMapping("/showTrips")
    public String showTrips(Model model, HttpServletRequest request, @CookieValue(value = "places", defaultValue = "0") String places, Authentication authentication) {
        Passenger passenger = ((CustomPassengerDetails) authentication.getPrincipal()).getPassenger();
        model.addAttribute("passenger",passenger);
        model.addAttribute(request.getSession().getAttribute("trips"));
        model.addAttribute("places",Integer.parseInt(places));
        return "tripsBySearch";
    }
}
