package com.vti.validation.car;

import com.vti.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CarIdLicensePlateNotExistsValidator
                            implements ConstraintValidator<CarIdLicensePlateNotExists, String> {
    @Autowired
    private ICarRepository carRepository;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return carRepository.existsByIdLicensePlate(value);
    }
}
