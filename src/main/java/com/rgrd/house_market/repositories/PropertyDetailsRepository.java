package com.rgrd.house_market.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgrd.house_market.model.PropertyDetails;

public interface PropertyDetailsRepository extends JpaRepository<PropertyDetails, Long> {
    
    List<PropertyDetails> findByOwnerId(Long ownerId);
}
