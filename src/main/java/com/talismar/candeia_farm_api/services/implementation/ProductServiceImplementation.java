/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.services.implementation;

import com.talismar.candeia_farm_api.entities.ProductEntity;
import com.talismar.candeia_farm_api.enums.MeasurementUnit;
import com.talismar.candeia_farm_api.repositories.ProductRepository;
import com.talismar.candeia_farm_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductEntity create(String name, MeasurementUnit measurementUnit) {
        ProductEntity newProduct = new ProductEntity();
        newProduct.setName(name);
        newProduct.setMeasurementUnit(measurementUnit);
        return this.productRepository.save(newProduct);
    }

    @Override
    public List<ProductEntity> listAll() {
        return this.productRepository.findAll();
    }
}
