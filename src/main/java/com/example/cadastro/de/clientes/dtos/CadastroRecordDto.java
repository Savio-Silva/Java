package com.example.cadastro.de.clientes.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroRecordDto(@NotNull @NotBlank String name, String adress, String email) {
}
