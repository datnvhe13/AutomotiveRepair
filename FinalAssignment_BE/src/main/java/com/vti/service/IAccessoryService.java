package com.vti.service;

import com.vti.entity.Accessory;
import com.vti.form.accessory.AccessoryFilterForm;
import com.vti.form.accessory.CreatingAccessoryForm;
import com.vti.form.accessory.UpdatingAccessoryForm;
import com.vti.form.car.CreatingCarForm;
import com.vti.form.car.UpdatingCarForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAccessoryService  {

    public Page<Accessory> getAllAccessory(Pageable pageable, AccessoryFilterForm filterForm);

    public void createAccessory(CreatingAccessoryForm form);

    public void updateAccessory(UpdatingAccessoryForm form);

    public void deleteAccessoryById(int id);

}
