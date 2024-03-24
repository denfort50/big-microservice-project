package ru.dkalchenko.catalogue.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductDto(@NotNull(message = "{product.title_null}")
                         @Size(min = TITLE_MIN, max = TITLE_MAX, message = "{product.title_invalid}") String title,
                         @Size(max = DETAILS_MAX, message = "{product.details_invalid}") String details) {

    private static final int TITLE_MIN = 3;
    private static final int TITLE_MAX = 50;
    private static final int DETAILS_MAX = 1000;
}
