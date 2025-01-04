package com.testetecnico.teste.tecnico.application.dtos.Product;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class GetByUuidProductInputDto {
    private UUID uuid;
}
