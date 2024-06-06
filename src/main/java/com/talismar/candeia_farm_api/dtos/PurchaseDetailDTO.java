/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api.dtos;

import java.time.LocalDateTime;

public record PurchaseDetailDTO(int amount, ProductDTO product, SupplierDTO supplier, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
