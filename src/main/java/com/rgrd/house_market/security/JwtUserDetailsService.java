package com.rgrd.house_market.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rgrd.house_market.model.UserDetails;
import com.rgrd.house_market.repositories.UserDetailsRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user from repository/database.
        UserDetails user = userDetailsRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new CustomUserDetails(
            user.getEmail(),
            user.getPassword(),
            user.getName(), 
            user.getRole());
    }
}
