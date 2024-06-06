/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.controllers;

import com.talismar.candeia_farm_api.dtos.ProductDTO;
import com.talismar.candeia_farm_api.dtos.PurchaseDTO;
import com.talismar.candeia_farm_api.dtos.PurchaseDetailDTO;
import com.talismar.candeia_farm_api.dtos.SupplierDTO;
import com.talismar.candeia_farm_api.entities.PurchaseEntity;
import com.talismar.candeia_farm_api.services.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/")
    public Page<PurchaseDetailDTO> listBySupplier(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<PurchaseEntity> entities = purchaseService.listAll(pageable);
        return entities.map(this::convertToDTO);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody @Valid PurchaseDTO purchaseDTO) {
        try {
            PurchaseEntity purchase = this.purchaseService.create(purchaseDTO.product(), purchaseDTO.supplier(), purchaseDTO.amount());
            System.out.println("HEREEEEEEEE");
            return ResponseEntity.status(201).body("CREATE");
        } catch (Exception exception) {
            return ResponseEntity.status(410).body(exception.getMessage());
        }
    }

    private PurchaseDetailDTO convertToDTO(PurchaseEntity purchase) {
        ProductDTO productDTO = new ProductDTO(purchase.getProduct().getName(), purchase.getProduct().getMeasurementUnit());
        SupplierDTO supplierDTO = new SupplierDTO(purchase.getSupplier().getName());
        return new PurchaseDetailDTO(purchase.getAmount(), productDTO, supplierDTO, purchase.getCreatedAt(), purchase.getUpdatedAt());
    }
}
