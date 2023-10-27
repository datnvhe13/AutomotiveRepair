package com.vti.validation.car;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CarIdLicensePlateNotExistsValidator.class)
public @interface CarIdLicensePlateNotExists {

    String message() default "CarIdLicensePlate has not existed !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
