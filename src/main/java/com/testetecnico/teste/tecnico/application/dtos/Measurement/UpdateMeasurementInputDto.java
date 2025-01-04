package com.testetecnico.teste.tecnico.application.dtos.Measurement;

import com.testetecnico.teste.tecnico.domain.enums.UnitEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMeasurementInputDto {
    private UUID uuid;
    private BigDecimal value;
    private UnitEnum unit;
}
