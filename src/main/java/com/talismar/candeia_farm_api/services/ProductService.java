/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.services;

import com.talismar.candeia_farm_api.entities.ProductEntity;
import com.talismar.candeia_farm_api.enums.MeasurementUnit;

import java.util.List;

public interface ProductService {
    ProductEntity create(String name, MeasurementUnit measurementUnit);
    List<ProductEntity> listAll();
}
