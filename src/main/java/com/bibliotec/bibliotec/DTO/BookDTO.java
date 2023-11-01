package com.bibliotec.bibliotec.DTO;

import com.bibliotec.bibliotec.Domains.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.UUID;
public record BookDTO(@NotBlank String title, @NotBlank String author, @NotNull Date published, List<UUID> category_ids) {
    @Override
    public List<UUID> category_ids() {
        return category_ids;
    }
}