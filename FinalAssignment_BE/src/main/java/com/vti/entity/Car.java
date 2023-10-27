package com.vti.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Car")
@Data
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CarPK id;

    @Column(name = "customer_name", length = 50, nullable = false)
    private String customerName;
    @Column(name = "catalogs", length = 50, nullable = false)
    private String catalogs;
    @Column(name = "car_maker", length = 50, nullable = false)
    private String carMaker;

    @OneToMany(mappedBy = "car")
    private List<Accessory> accessories;






}















