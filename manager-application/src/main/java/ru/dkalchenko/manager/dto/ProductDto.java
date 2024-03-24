package ru.dkalchenko.manager.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductDto(@NotNull(message = "{product.title_null}")
                         @Size(min = 3, max = 50, message = "{product.title_invalid}") String title,
                         @Size(max = 1000, message = "{product.details_invalid}") String details) {
}
