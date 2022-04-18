package com.gadelev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
    public class LoginController {
        @GetMapping("/login")
        public String getLoginPage(@RequestParam(value = "reason", required = false) String reason) {
            if (reason != null && reason.equals("error")) {
                return "fail";
            }
            return "logiin";
        }
    }

