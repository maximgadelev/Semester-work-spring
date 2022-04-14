package com.gadelev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {
    @GetMapping("/reg")
    public String getLoginPage() {
        return "regiistration";
    }
}
