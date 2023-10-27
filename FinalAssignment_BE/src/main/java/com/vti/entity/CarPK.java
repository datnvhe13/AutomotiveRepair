package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarPK implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "license_plate", nullable = false)
    private String licensePlate;
    @Column(name = "repair_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date repairDate;
}
