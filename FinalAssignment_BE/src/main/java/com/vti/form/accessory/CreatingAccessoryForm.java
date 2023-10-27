package com.vti.form.accessory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreatingAccessoryForm {

    private int id;
    @Length(max = 50, message = "LicensePlate's length must less than or equal to 50")
    @NotBlank(message = "LicensePlate must not null")
    private String carIdLicensePlate;
    private Date carIdRepairDate;
    @Length(max = 50, message = "Name must less than or equal to 50")
    @NotBlank(message = "Name must not null")
    private String name;
    @NotBlank(message = "Price must not null")
    private Float price;
    @Length(max = 50, message = "StatusDamaged must less than or equal to 50")
    @NotBlank(message = "StatusDamaged must not null")
    private String statusDamaged;
    @Length(max = 50, message = "RepairStatus must less than or equal to 50")
    @NotBlank(message = "RepairStatus must not null")
    private String repairStatus;
}
