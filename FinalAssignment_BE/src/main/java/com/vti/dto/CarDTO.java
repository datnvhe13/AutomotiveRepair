package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO {

    private String idLicensePlate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date idRepairDate;

    private String customerName;
    private String catalogs;
    private String carMaker;
//    private List<AccessoryDTO> accessories;
//
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    public static class AccessoryDTO{
//        private String name;
//        private Float price;
//    }

}
