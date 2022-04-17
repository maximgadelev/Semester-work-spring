package com.gadelev.security;

import com.gadelev.model.Passenger;
import com.gadelev.repo.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomPassengerDetailsService implements UserDetailsService {
    @Autowired
    private PassengerRepository passengerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Passenger> user = passengerRepository.getByEmail(username);
        return user.map(CustomPassengerDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Passenger %s not found", username)));
    }
}
