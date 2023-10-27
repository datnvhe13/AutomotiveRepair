package com.vti.service.iml;

import com.vti.entity.Accessory;
import com.vti.entity.Car;
import com.vti.entity.CarPK;
import com.vti.form.car.CarFilterForm;
import com.vti.form.car.CreatingCarForm;
import com.vti.form.car.UpdatingCarForm;
import com.vti.repository.IAccessoryRepository;
import com.vti.repository.ICarRepository;
import com.vti.service.ICarService;
import com.vti.specification.CarSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class CarService implements ICarService {

    @Autowired
    private ICarRepository carRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IAccessoryRepository accessoryRepository;


    @Override
    public Page<Car> getAllCars(Pageable pageable, CarFilterForm filterForm) {
        Specification<Car> where = CarSpecification.buildWhere(filterForm);
        return carRepository.findAll(where, pageable);
    }

    @Override
    public void createCar(CreatingCarForm form) {
        //convert creatingCarForm to Car
        Car car = modelMapper.map(form, Car.class);
        //create new car
        carRepository.save(car);
    }

    @Override
    public void updateCar(UpdatingCarForm form) {
        Car car = carRepository.findById(new CarPK(form.getIdLicensePlate(), form.getIdRepairDate())).orElse(null);
        if (Objects.isNull(car))
            return;

        if (!StringUtils.isEmpty(form.getCustomerName()))
            car.setCustomerName(form.getCustomerName());

        if (!StringUtils.isEmpty(form.getCatalogs()))
            car.setCatalogs(form.getCatalogs());

        if (!StringUtils.isEmpty(form.getCarMaker()))
            car.setCarMaker(form.getCarMaker());

        carRepository.save(car);
    }

    @Override
    @Transactional
    public void deleteCarByIdLicensePlate(String IdLicensePlate) {
        carRepository.deleteByIdLicensePlate(IdLicensePlate);
    }

//    @Override
//    public void deleteCarByIdLicensePlate(CarPK licensePlate) {
//        carRepository.deleteByIdLicensePlate(licensePlate);
//    }


}


















