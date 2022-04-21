package com.gadelev.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.gadelev.helper.CloudinaryHelper;
import com.gadelev.model.Passenger;
import com.gadelev.security.CustomPassengerDetails;
import com.gadelev.service.PassengerService;
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
import java.util.Map;

@Controller
public class UserController {
    private final PassengerService passengerService;


    @Autowired
    public UserController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("/passenger")
    public String getProfile(Model model, Authentication authentication) {
        Passenger passenger = ((CustomPassengerDetails) authentication.getPrincipal()).getPassenger();
        model.addAttribute("passenger", passenger);
        return "profilePassenger";
    }

    @PostMapping("/upload")
    public String uploadPhoto(HttpServletRequest request,Authentication authentication) throws ServletException, IOException {
        Passenger passenger = ((CustomPassengerDetails) authentication.getPrincipal()).getPassenger();
        File file = getFile(request);
        String filename = "passengerPhoto" + passenger.getId();
        Cloudinary cloudinary= CloudinaryHelper.getInstance();
        Map upload =  cloudinary.uploader().upload(file,
                ObjectUtils.asMap("public_id", filename));
        String url = (String) upload.get("url");
        passengerService.updatePhoto(passenger,url);
        return "redirect:/passenger";
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
