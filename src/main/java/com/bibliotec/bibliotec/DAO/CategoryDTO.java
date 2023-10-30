package com.bibliotec.bibliotec.DAO;

import jakarta.validation.constraints.NotBlank;

public record CategoryDTO(@NotBlank String description) {
}
