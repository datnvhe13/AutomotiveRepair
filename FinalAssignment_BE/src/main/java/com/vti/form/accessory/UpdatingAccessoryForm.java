package com.vti.form.accessory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UpdatingAccessoryForm {
    private int id;
    private String carIdLicensePlate;
    private Date carIdRepairDate;

    private String name;
    private Float price;
    private String statusDamaged;
    private String repairStatus;
}
