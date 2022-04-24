package com.gadelev.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.gadelev.dto.CreateCarDto;
import com.gadelev.dto.CreateTripDto;
import com.gadelev.dto.TripDto;
import com.gadelev.helper.CloudinaryHelper;
import com.gadelev.model.Car;
import com.gadelev.model.Passenger;
import com.gadelev.security.CustomPassengerDetails;
import com.gadelev.service.CarService;
import com.gadelev.service.PassengerService;
import com.gadelev.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private final PassengerService passengerService;
    private final CarService carService;
    private final TripService tripService;

    @Autowired
    public UserController(PassengerService passengerService, CarService carService, TripService tripService) {
        this.passengerService = passengerService;
        this.carService = carService;
        this.tripService = tripService;
    }

    @GetMapping("/profile")
    public String getProfile(Model model, Authentication authentication) {
        Passenger passenger = ((CustomPassengerDetails) authentication.getPrincipal()).getPassenger();
        model.addAttribute("passenger", passenger);
        if (passenger.getRole().equals(Passenger.Role.PASSENGER)) {
            return "profilePassenger";
        } else {
            model.addAttribute("car", passenger.getCar());
            return "driverProfile";
        }
    }

    @PostMapping("/upload")
    public String uploadPhoto(HttpServletRequest request, Authentication authentication) throws ServletException, IOException {
        Passenger passenger = ((CustomPassengerDetails) authentication.getPrincipal()).getPassenger();
        File file = getFile(request);
        String filename = "passengerPhoto" + passenger.getId();
        Cloudinary cloudinary = CloudinaryHelper.getInstance();
        Map upload = cloudinary.uploader().upload(file,
                ObjectUtils.asMap("public_id", filename));
        String url = (String) upload.get("url");
        passengerService.updatePhoto(passenger, url);
        return "redirect:/profile";
    }

    @PostMapping("/addCar")
    public String addCar(CreateCarDto createCarDto, Authentication authentication) {
        Passenger passenger = ((CustomPassengerDetails) authentication.getPrincipal()).getPassenger();
        carService.saveCar(createCarDto, passenger);
        return "redirect:/profile";
    }

    @GetMapping("/addCar")
    public String getCarPage(Model mode) {
        mode.addAttribute("car", new CreateCarDto());
        return "addCar";
    }

    @GetMapping("/addTrip")
    public String getTripPage() {
        return "addTrip";
    }

    @PostMapping("/addTrip")
    public String addTrip(CreateTripDto createTripDto, Authentication authentication) {
        Passenger passenger = ((CustomPassengerDetails) authentication.getPrincipal()).getPassenger();
        Car car = passenger.getCar();
        createTripDto.setCar(car);
        createTripDto.setFreePlaces(car.getNumberOfPlaces());
        tripService.saveTrip(createTripDto);
        return "redirect:/profile";
    }

    @GetMapping("/findDriverByTrip")
    public String findDriverByTrip(HttpServletRequest httpServletRequest, Model model) {
        Integer tripId = Integer.parseInt(httpServletRequest.getParameter("id_trip"));
        model.addAttribute("tripDriver",passengerService.getByTripId(tripId));
        model.addAttribute("driverCar",passengerService.getByTripId(tripId).getCar());
        System.out.println(passengerService.getByTripId(tripId).getCar());
       return "driversTrip";
    }

    @GetMapping("/activePassengerTrips")
    public String getActivePassengerTrip(Authentication authentication, Model model) {
        Passenger passenger = ((CustomPassengerDetails) authentication.getPrincipal()).getPassenger();
        List<TripDto> tripDtoList = tripService.getActiveTripByPassenger(passenger);
        System.out.println(tripDtoList.size());
        model.addAttribute("passengersActiveTrips", tripDtoList);
        return "activePassengerTrips";
    }

    private File getFile(HttpServletRequest request) throws IOException, ServletException {
        Part part = request.getPart("file");
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        InputStream content = part.getInputStream();
        File file = new File(fileName);
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[content.available()];
        content.read(buffer);
        outputStream.write(buffer);
        return file;
    }
}
