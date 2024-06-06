/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.talismar.candeia_farm_api.enums.MeasurementUnit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotEmpty()
    @Column(nullable = false)
    private String name;

    @Column(length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private MeasurementUnit measurementUnit;
    @OneToMany(mappedBy = "product")
    private List<PurchaseEntity> purchases;

    public ProductEntity() { }

    public ProductEntity(Long id, String name, MeasurementUnit measurementUnit) {
        this.id = id;
        this.name = name;
        this.measurementUnit = measurementUnit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    @JsonManagedReference
    public List<PurchaseEntity> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseEntity> purchases) {
        this.purchases = purchases;
    }
}
