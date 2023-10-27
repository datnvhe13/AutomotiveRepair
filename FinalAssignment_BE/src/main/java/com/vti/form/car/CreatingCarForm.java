package com.vti.form.car;

import com.vti.entity.Accessory;
import com.vti.validation.car.CarIdLicensePlateExists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreatingCarForm {
    @Length(max = 50, message = "LicensePlate's length must less than or equal to 50")
    @NotBlank(message = "LicensePlate must not null")
    @CarIdLicensePlateExists
    private String idLicensePlate;
    private Date idRepairDate;
    @Length(max = 50, message = "Customer's name must less than or equal to 50")
    @NotBlank(message = "Customer's name must not null")
    private String customerName;
    @Length(max = 50, message = "Catalog must less than or equal to 50")
    @NotBlank(message = "Catalog must not null")
    private String catalogs;
    @Length(max = 50, message = "CarMaker must less than or equal to 50")
    @NotBlank(message = "CarMaker must not null")
    private String carMaker;
    //private List<Accessory> accessories;

//    @Getter
//    @Setter
//    @NoArgsConstructor
//    public static class Accessory{
//        private String name;
//        private Float price;
//        private String statusDamaged;
//        private String repairStatus;
//    }

}
