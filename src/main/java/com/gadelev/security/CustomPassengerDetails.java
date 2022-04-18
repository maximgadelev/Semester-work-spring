package com.gadelev.security;

import com.gadelev.model.Passenger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomPassengerDetails implements UserDetails {
    private Passenger passenger;

    public CustomPassengerDetails(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        passenger.getRoles().forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getName())));
        return authorities;
    }

    @Override
    public String getPassword() {
        return passenger.getPassword();
    }

    @Override
    public String getUsername() {
        return passenger.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
