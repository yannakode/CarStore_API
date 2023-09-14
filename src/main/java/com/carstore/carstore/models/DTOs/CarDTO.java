package com.carstore.carstore.models.DTOs;

import com.carstore.carstore.models.enums.ValidBrands;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CarDTO(
        @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces.")
        @NotEmpty(message = "Name must not be null.") String name,
        @NotNull @Enumerated(EnumType.STRING) ValidBrands brand,
        @NotNull(message = "Color must not be null.") String color,
        @NotNull(message = "Fabrication year must not be null.") String fabricationYear
) {
}

