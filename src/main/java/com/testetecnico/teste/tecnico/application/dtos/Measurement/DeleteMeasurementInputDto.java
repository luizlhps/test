package com.testetecnico.teste.tecnico.application.dtos.Measurement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
public class DeleteMeasurementInputDto {
    private UUID uuid;
}
