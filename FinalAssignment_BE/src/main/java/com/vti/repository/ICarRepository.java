package com.vti.repository;

import com.vti.entity.Car;
import com.vti.entity.CarPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICarRepository extends JpaRepository<Car, CarPK>, JpaSpecificationExecutor<Car> {
        void deleteByIdLicensePlate(String licensePlate);

//        boolean existsByName(String name);
        boolean existsByIdLicensePlate(String idLicensePlate);

        //void deleteByIdLicensePlate(CarPK licensePlate);
}
