package com.rgrd.house_market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgrd.house_market.exceptions.ResourceNotFoundException;
import com.rgrd.house_market.exceptions.response.ErrorCodes;
import com.rgrd.house_market.model.PropertyDetails;
import com.rgrd.house_market.model.UserDetails;
import com.rgrd.house_market.repositories.PropertyDetailsRepository;
import com.rgrd.house_market.repositories.UserDetailsRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/properties")
public class PropertyDetailsController {
    
    @Autowired
    private PropertyDetailsRepository propertyDetailsRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    // 1. Find property by propertyId.
    @GetMapping("/{propertyId}")
    public PropertyDetails getPropertyById(@PathVariable Long propertyId) {
        return propertyDetailsRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCodes.PROPERTY_NOT_FOUND, "Property not found with ID: " + propertyId));
    }

    // 2. Find all properties.
    @GetMapping
    public List<PropertyDetails> getAllProperties() {
        return propertyDetailsRepository.findAll();
    }
    
    // 3. Add new property by owner.
    @PostMapping("/{ownerId}")
    public PropertyDetails addProperty(@PathVariable Long ownerId,@Valid @RequestBody PropertyDetails property) {
        UserDetails owner = userDetailsRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCodes.USER_NOT_FOUND, "Owner not found with ID: " + ownerId));

        property.setOwner(owner);
        return propertyDetailsRepository.save(property);
    }
    
    // 4. Find properties by ownerId.
    @GetMapping("/owner/{ownerId}")
    public List<PropertyDetails> getPropertiesByOwner(@PathVariable Long ownerId) {
        return propertyDetailsRepository.findByOwnerId(ownerId);
    }

    // 5. Update property details.
    @PutMapping("/{propertyId}")
    public PropertyDetails updateProperty(@PathVariable Long propertyId,@Valid @RequestBody PropertyDetails updatedProperty) {
        PropertyDetails property = propertyDetailsRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCodes.PROPERTY_NOT_FOUND,
                        "Property not found with ID: " + propertyId));

        property.setTitle(updatedProperty.getTitle());
        property.setDescription(updatedProperty.getDescription());
        property.setPrice(updatedProperty.getPrice());
        property.setLocation(updatedProperty.getLocation());
        property.setAvailability(updatedProperty.getAvailability());

        return propertyDetailsRepository.save(property);
    }

    // 6. Delete property record.
    @DeleteMapping("/{propertyId}")
    public void deleteProperty(@PathVariable Long propertyId) {
        propertyDetailsRepository.deleteById(propertyId);
    }

    // The user management or adding search filters will start here :)
}
