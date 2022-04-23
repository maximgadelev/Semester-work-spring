package com.gadelev.helper;

import com.gadelev.dto.PassengerDto;
import com.gadelev.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SessionHelper extends
        SavedRequestAwareAuthenticationSuccessHandler
        implements AuthenticationSuccessHandler {

    private final PassengerService passengerService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException,
            ServletException {

        String email = authentication.getName();
        PassengerDto user = passengerService.getPassengerByEmail(email);
        request.getSession().setAttribute("user", user);
        request.getSession().removeAttribute("authenticationFailure");

        response.sendRedirect("/main");
    }
}