package com.vti.service.iml;

import com.vti.entity.Accessory;
import com.vti.form.accessory.AccessoryFilterForm;
import com.vti.form.accessory.CreatingAccessoryForm;
import com.vti.form.accessory.UpdatingAccessoryForm;
import com.vti.repository.IAccessoryRepository;
import com.vti.service.IAccessoryService;
import com.vti.specification.AccessorySpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AccessoryService implements IAccessoryService {

    @Autowired
    private IAccessoryRepository accessoryRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Page<Accessory> getAllAccessory(Pageable pageable, AccessoryFilterForm filterForm) {
        Specification<Accessory> where = AccessorySpecification.buildWhere(filterForm);
        return accessoryRepository.findAll(where, pageable);
    }

    @Override
    public void createAccessory(CreatingAccessoryForm form) {
        //convert creatingAccessoryForm to Accessory
        Accessory accessory = modelMapper.map(form, Accessory.class);
        //create new Accessory
        accessoryRepository.save(accessory);
    }

    @Override
    public void updateAccessory(UpdatingAccessoryForm form) {
        //convert updatingAccessory form to Accessory
        Accessory accessory = modelMapper.map(form, Accessory.class);
        // updating
        accessoryRepository.save(accessory);
    }

    @Override
    public void deleteAccessoryById(int id) {
        accessoryRepository.deleteById(id);
    }
}
