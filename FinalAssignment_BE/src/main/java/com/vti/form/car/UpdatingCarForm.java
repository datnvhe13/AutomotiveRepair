package com.vti.form.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UpdatingCarForm {
    private String idLicensePlate;
    private Date idRepairDate;
    private String customerName;
    private String catalogs;
    private String carMaker;
}
