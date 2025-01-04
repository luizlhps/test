package com.testetecnico.teste.tecnico.application.dtos.Product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testetecnico.teste.tecnico.domain.enums.ProductTypeEnum;
import com.testetecnico.teste.tecnico.domain.enums.UnitEnum;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProductOutputDto {
    private UUID uuid;
    private String name;
    private BigDecimal price;
    private ProductTypeEnum type;
    private BigDecimal shipping;
    private BigDecimal totalValue;
    private BigDecimal priceWithDiscount;

    @JsonProperty("isOnPromotion")
    private boolean isOnPromotion;
    private MeasurementDto measurement;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class MeasurementDto {

        private BigDecimal value;
        private UnitEnum unit;
    }
}
