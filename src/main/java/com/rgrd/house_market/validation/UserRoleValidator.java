package com.rgrd.house_market.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserRoleValidator implements ConstraintValidator<ValidUserRole, UserRole> {

    @Override
    public boolean isValid(UserRole value, ConstraintValidatorContext context) {
        // Check if the value is one of the valid roles
        return value == UserRole.OWNER || value == UserRole.CUSTOMER || value == UserRole.ADMIN;
    }
}
