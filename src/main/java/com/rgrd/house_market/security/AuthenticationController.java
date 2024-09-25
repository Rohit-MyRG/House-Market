package com.rgrd.house_market.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

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
        // Authenticate the user
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        // Load user from database
        CustomUserDetails userDetails = jwtUserDetailsService.loadUserByUsername(request.getEmail());

        // Generate JWT access and refresh tokens
        String jwtToken = jwtTokenUtil.generateToken(userDetails.getUsername(), userDetails.getName(), userDetails.getRole());
        String refreshToken = jwtTokenUtil.generateRefreshToken(userDetails.getUsername());

        // Return both tokens in the response
        return ResponseEntity.ok(new AuthenticationResponse(jwtToken, refreshToken));
    }
    
    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refreshToken");
        if (jwtTokenUtil.validateRefreshToken(refreshToken)) {
            String username = jwtTokenUtil.extractUsername(refreshToken);
            CustomUserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);

            // Generate a new access token
            String newAccessToken = jwtTokenUtil.generateToken(userDetails.getUsername(), userDetails.getName(), userDetails.getRole());

            return ResponseEntity.ok(new AuthenticationResponse(newAccessToken, refreshToken));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Refresh Token");
        }
    }

}

