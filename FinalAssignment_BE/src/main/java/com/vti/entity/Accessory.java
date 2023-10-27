package com.vti.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Accessory")
@Data
public class Accessory {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "license_plate", referencedColumnName = "license_plate"),
            @JoinColumn(name = "repair_date", referencedColumnName = "repair_date")
    })
    private Car car;

    @Column(name = "`name`", length = 50, nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Float price;
    @Column(name = "status_damaged", length = 50, nullable = false)
    private String statusDamaged;
    @Column(name = "repair_status", length = 50, nullable = false)
    private String repairStatus;

}
