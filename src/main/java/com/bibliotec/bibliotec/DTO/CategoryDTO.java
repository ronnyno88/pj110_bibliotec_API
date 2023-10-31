package com.bibliotec.bibliotec.DTO;

import jakarta.validation.constraints.NotBlank;

public record CategoryDTO(@NotBlank String description) {
}
