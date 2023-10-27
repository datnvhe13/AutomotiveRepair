package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AccessoryDTO {
    private int id;
    private String carIdLicensePlate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date carIdRepairDate;
    private String name;
    private Float price;
    private String statusDamaged;
    private String repairStatus;
}
