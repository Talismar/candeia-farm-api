/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.services.implementation;

import com.talismar.candeia_farm_api.dtos.PurchaseDTO;
import com.talismar.candeia_farm_api.dtos.ResponseErrorDTO;
import com.talismar.candeia_farm_api.entities.ProductEntity;
import com.talismar.candeia_farm_api.entities.PurchaseEntity;
import com.talismar.candeia_farm_api.entities.SupplierEntity;
import com.talismar.candeia_farm_api.repositories.ProductRepository;
import com.talismar.candeia_farm_api.repositories.PurchaseRepository;
import com.talismar.candeia_farm_api.repositories.SupplierRepository;
import com.talismar.candeia_farm_api.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImplementation implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Page<PurchaseEntity> listAll(Pageable pageable) {
        return purchaseRepository.findAll(pageable);
    }

    @Override
    public PurchaseEntity create(Long productId, Long supplierId, int amount) throws Exception {
        Optional<ProductEntity> productAlreadyExists = productRepository.findById(productId);
        Optional<SupplierEntity> supplierAlreadyExists = supplierRepository.findById(supplierId);

        if (productAlreadyExists.isEmpty() || supplierAlreadyExists.isEmpty()) {
            throw new Exception("Not found");
        }

        PurchaseEntity newPurchase = new PurchaseEntity();
        newPurchase.setProduct(productAlreadyExists.get());
        newPurchase.setSupplier(supplierAlreadyExists.get());
        newPurchase.setAmount(amount);

        return this.purchaseRepository.save(newPurchase);
    }
}
