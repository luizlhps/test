package com.testetecnico.teste.tecnico.application.dtos.Product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testetecnico.teste.tecnico.domain.enums.ProductTypeEnum;
import com.testetecnico.teste.tecnico.domain.enums.UnitEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByUuidProductOutputDto {
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
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class MeasurementDto {

        private BigDecimal uuid;
        private BigDecimal value;
    }

}
