package com.vti.service;


import com.vti.entity.Car;
import com.vti.entity.CarPK;
import com.vti.form.car.CarFilterForm;
import com.vti.form.car.CreatingCarForm;
import com.vti.form.car.UpdatingCarForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICarService {
    public Page<Car> getAllCars(Pageable pageable, CarFilterForm filterForm);

    public void createCar(CreatingCarForm form);

    public void updateCar(UpdatingCarForm form);

    public void deleteCarByIdLicensePlate(String IdLicensePlate);

    //public void deleteCarByIdLicensePlate(CarPK licensePlate);

}
