package com.bibliotec.bibliotec.DAO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record BookDTO(@NotBlank String title, @NotBlank String author, @NotNull Date published) {
}