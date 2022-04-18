package com.gadelev.security;

import com.gadelev.repo.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomPassengerDetailsService implements UserDetailsService {
    @Autowired
    private PassengerRepository passengerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return new CustomPassengerDetails(passengerRepository.getByEmail(username).get());
    }
}
