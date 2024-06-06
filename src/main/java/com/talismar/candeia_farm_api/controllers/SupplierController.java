package com.talismar.candeia_farm_api.controllers;

import com.talismar.candeia_farm_api.dtos.ResponseErrorDTO;
import com.talismar.candeia_farm_api.dtos.SupplierDTO;
import com.talismar.candeia_farm_api.entities.PurchaseEntity;
import com.talismar.candeia_farm_api.entities.SupplierEntity;
import com.talismar.candeia_farm_api.repositories.SupplierRepository;
import com.talismar.candeia_farm_api.services.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
@Validated
public class SupplierController {
    @Autowired
    private SupplierRepository repository;

    @Autowired
    private SupplierService service;

    @GetMapping("/")
    public List<SupplierEntity> list() {
        List<SupplierEntity> supplierList = new ArrayList<>();

//        for (SupplierEntity supplier : this.repository.findAll()) {
//            List<PurchaseEntity> purchaseList = new ArrayList<>();
//
//            for (PurchaseEntity purchase : supplier.getPurchases()) {
//                PurchaseEntity test = new PurchaseEntity();
//
//                test.setAmount(purchase.getAmount());
//                test.setId(purchase.getId());
//                test.setCreatedAt(purchase.getCreatedAt());
//                test.setUpdatedAt(purchase.getUpdatedAt());
//
//                purchaseList.add(test);
//            }
//
//
//        }

        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable(value = "id") Long id) {
        Optional<SupplierEntity> supplier = this.repository.findById(id);

        if (supplier.isEmpty()) {
            return ResponseEntity.status(400).body(new ResponseErrorDTO("Not found"));
        }

        return ResponseEntity.status(200).body(supplier);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public SupplierEntity create(@RequestBody @Valid SupplierDTO supplier) {
        SupplierEntity newSupplier = new SupplierEntity();
        BeanUtils.copyProperties(supplier, newSupplier);
        return repository.save(newSupplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        Optional<SupplierEntity> supplier = this.repository.findById(id);

        if (supplier.isEmpty()) {
            return ResponseEntity.status(400).body(new ResponseErrorDTO("Not found"));
        }

        this.repository.delete(supplier.get());
        return ResponseEntity.status(204).body("");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody @Valid SupplierDTO supplierDTO) {
        Optional<SupplierEntity> supplier = this.repository.findById(id);

        if (supplier.isEmpty()) {
            return ResponseEntity.status(400).body(new ResponseErrorDTO("Not found"));
        }

        SupplierEntity auxSupplier = new SupplierEntity();
        BeanUtils.copyProperties(supplier, auxSupplier);
        BeanUtils.copyProperties(supplierDTO, auxSupplier);
        auxSupplier.setId(supplier.get().getId());

        return ResponseEntity.status(200).body(this.repository.save(auxSupplier));
    }
}
