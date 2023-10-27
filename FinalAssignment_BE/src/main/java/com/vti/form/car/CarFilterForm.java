package com.vti.form.car;

import com.vti.validation.car.CarIdLicensePlateNotExists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CarFilterForm {
    //search by license_plate, customer_name, car_maker
    @CarIdLicensePlateNotExists
    private String search;
    //search by repair_date
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date repairDate;
    //search by minYear
    private int minYear;

}
