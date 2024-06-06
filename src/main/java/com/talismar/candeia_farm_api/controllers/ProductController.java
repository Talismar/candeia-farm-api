/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.controllers;

import com.talismar.candeia_farm_api.dtos.ProductDTO;
import com.talismar.candeia_farm_api.entities.ProductEntity;
import com.talismar.candeia_farm_api.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public List<ProductEntity> list() {
        return this.productService.listAll();
    }

    @PostMapping("/")
    public ProductEntity create(@RequestBody @Valid ProductDTO productDto) {
        return this.productService.create(productDto.name(), productDto.measurementUnit());
    }
}
