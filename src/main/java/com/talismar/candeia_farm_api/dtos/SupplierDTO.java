/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record SupplierDTO (@NotBlank String name){
}
