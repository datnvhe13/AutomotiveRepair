package com.vti.controller;

import com.vti.dto.AccessoryDTO;
import com.vti.dto.CarDTO;
import com.vti.entity.Accessory;
import com.vti.entity.Car;
import com.vti.form.accessory.AccessoryFilterForm;
import com.vti.form.accessory.CreatingAccessoryForm;
import com.vti.form.accessory.UpdatingAccessoryForm;
import com.vti.service.IAccessoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accessories")
@CrossOrigin("*")
public class AccessoryController {
    @Autowired
    private IAccessoryService accessoryService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<AccessoryDTO> getAllAccessories(Pageable pageable, AccessoryFilterForm filterForm){
        // get All Accessories
        Page<Accessory> accessoryPage = accessoryService.getAllAccessory(pageable, filterForm);
        // get content
        List<Accessory> accessories = accessoryPage.getContent();

        // convert List to List DTO
        List<AccessoryDTO> accessoryDTOS = modelMapper.map(accessories, new TypeToken<List<AccessoryDTO>>(){}.getType());
        // push into new page
        Page<AccessoryDTO> accessoryDTOPage = new PageImpl<>(accessoryDTOS, pageable, accessoryPage.getTotalElements());
        return  accessoryDTOPage;
    }

    @PostMapping
    public void createAccessory(@RequestBody CreatingAccessoryForm form){
        accessoryService.createAccessory(form);
    }

    @PutMapping("/{id}")
    public void updateAccessory(@PathVariable(name = "id") int id, @RequestBody UpdatingAccessoryForm form){
        form.setId(id);
        accessoryService.updateAccessory(form);
    }

    @DeleteMapping("/{id}")
    public void deleteAccessory(@PathVariable(name = "id") int id){
        accessoryService.deleteAccessoryById(id);
    }
}
