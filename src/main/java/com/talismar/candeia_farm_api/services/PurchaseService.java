/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.services;

import com.talismar.candeia_farm_api.entities.PurchaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PurchaseService {
    public Page<PurchaseEntity> listAll(Pageable pageable);
    public PurchaseEntity create(Long productId, Long supplierId, int amount) throws Exception;
}
