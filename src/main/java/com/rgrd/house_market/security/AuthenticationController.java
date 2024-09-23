package com.rgrd.house_market.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationController {

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
        // System.out.println("###################You are here");
        // Authenticate the user
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        // Load user from database
        CustomUserDetails userDetails = jwtUserDetailsService.loadUserByUsername(request.getEmail());
        // Generate JWT token
        String jwtToken = jwtTokenUtil.generateToken(userDetails.getUsername(), userDetails.getName(), userDetails.getRole()); 

        // Return the token in the response
        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }
}

