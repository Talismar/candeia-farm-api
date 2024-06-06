/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.services.implementation;

import com.talismar.candeia_farm_api.entities.SupplierEntity;
import com.talismar.candeia_farm_api.repositories.SupplierRepository;
import com.talismar.candeia_farm_api.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImplementation implements SupplierService  {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<SupplierEntity> listAll() {
        // List<SupplierEntity> result = new ArrayList<>();
        return this.supplierRepository.findAll();
    }

    @Override
    public List<SupplierEntity> listByPurchase() {
        return null;
    }
}
