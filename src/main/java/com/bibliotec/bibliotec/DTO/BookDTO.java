package com.bibliotec.bibliotec.DTO;

import com.bibliotec.bibliotec.Domains.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;
public record BookDTO(@NotBlank String title, @NotBlank String author, @NotNull Date published, UUID category_id) {
    @Override
    public UUID category_id() {
        return category_id;
    }
}