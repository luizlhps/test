package com.testetecnico.teste.tecnico.application.dtos.Measurement;

import com.testetecnico.teste.tecnico.domain.enums.UnitEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetByUuidMeasurementOutputDto {
    private UUID uuid;
    private BigDecimal value;
    private UnitEnum unit;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private boolean isDeleted;
}
