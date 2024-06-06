/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.services;

import com.talismar.candeia_farm_api.entities.SupplierEntity;
import com.talismar.candeia_farm_api.repositories.SupplierRepository;

import java.util.List;

public interface SupplierService {
    public List<SupplierEntity> listAll();
    public List<SupplierEntity> listByPurchase ();
}
