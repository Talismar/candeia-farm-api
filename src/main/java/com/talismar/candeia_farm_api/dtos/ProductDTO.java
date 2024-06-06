/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.dtos;

import com.talismar.candeia_farm_api.enums.MeasurementUnit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(@NotBlank String name, @NotNull MeasurementUnit measurementUnit) {
}
