package com.vti.repository;

import com.vti.entity.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IAccessoryRepository extends JpaRepository<Accessory, Integer>, JpaSpecificationExecutor<Accessory> {

}
