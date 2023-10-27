package com.vti.controller;

import com.vti.dto.CarDTO;
import com.vti.entity.Car;
import com.vti.entity.CarPK;
import com.vti.form.car.CarFilterForm;
import com.vti.form.car.CreatingCarForm;
import com.vti.form.car.UpdatingCarForm;
import com.vti.service.ICarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
@CrossOrigin("*")
@Validated
public class CarController {
    @Autowired
    private ICarService carService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<CarDTO> getAllCars(Pageable pageable, CarFilterForm filterForm){
        //get All Cars
        Page<Car> carPage = carService.getAllCars(pageable, filterForm);
        //get content
        List<Car> cars = carPage.getContent();


        // convert to list dto
        List<CarDTO> carDTOS = modelMapper.map(cars, new TypeToken<List<CarDTO>>(){}.getType());
        //push into new page
        Page<CarDTO> carDTOPage = new PageImpl<>(carDTOS, pageable, carPage.getTotalElements());

        return carDTOPage;
    }

    @PostMapping
    public void createCar(@RequestBody @Valid CreatingCarForm form){
        carService.createCar(form);
    }

    @PutMapping("")
    public void updateCar(@RequestBody UpdatingCarForm form){
        carService.updateCar(form);
    }

    @DeleteMapping("/{idLicensePlate}")
    public void deleteCarByIdLicensePlate(@PathVariable(name = "idLicensePlate") String IdLicensePlate){
        carService.deleteCarByIdLicensePlate(IdLicensePlate);
    }

//    @DeleteMapping("/{idLicensePlate}")
//    public void deleteCarByIdLicensePlate(@PathVariable(name = "idLicensePlate") CarPK IdLicensePlate){
//        carService.deleteCarByIdLicensePlate(IdLicensePlate);
//    }

}