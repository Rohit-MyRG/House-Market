package com.rgrd.house_market.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = UserRoleValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUserRole {
    String message() default "Invalid role. Allowed roles are: OWNER, CUSTOMER, ADMIN";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
