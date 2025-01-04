package com.testetecnico.teste.tecnico.application.dtos.Measurement;

import com.testetecnico.teste.tecnico.domain.enums.UnitEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class CreateMeasurementInputDto {

    private BigDecimal value;
    private UnitEnum unit;


}