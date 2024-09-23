package com.rgrd.house_market.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgrd.house_market.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    
    Optional<UserDetails> findByEmail(String email);  
}
