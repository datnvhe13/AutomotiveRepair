package com.vti.validation.car;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CarIdLicensePlateExistsValidator.class)
public @interface CarIdLicensePlateExists {

    String message() default "CarIdLicensePlate has existed !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
