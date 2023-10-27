package com.vti.form.accessory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AccessoryFilterForm {
    // search by carLicense_plate, accessoryName
    private String search;
    // search by carRepair_date
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date carRepairDate;

}
