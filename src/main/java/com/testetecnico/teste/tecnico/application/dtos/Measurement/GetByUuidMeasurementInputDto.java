package com.testetecnico.teste.tecnico.application.dtos.Measurement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class GetByUuidMeasurementInputDto {
    private UUID uuid;


}
