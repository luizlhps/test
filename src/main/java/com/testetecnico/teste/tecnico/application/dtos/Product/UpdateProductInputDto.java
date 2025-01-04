package com.testetecnico.teste.tecnico.application.dtos.Product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testetecnico.teste.tecnico.adapters.web.validations.NotZeroAndNotNullConstraint;
import com.testetecnico.teste.tecnico.adapters.web.validations.ValueOfEnum;
import com.testetecnico.teste.tecnico.domain.enums.ProductTypeEnum;
import com.testetecnico.teste.tecnico.domain.enums.UnitEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateProductInputDto {
    @NotNull
    private UUID uuid;

    @NotZeroAndNotNullConstraint
    @Positive
    @Schema(description = "Valor do produto", defaultValue = "1000")
    private BigDecimal price;

    @NotBlank
    @Schema(description = "Nome do produto", defaultValue = "CHEVROLET CELTA 2002")
    private String name;

    @NotNull
    @ValueOfEnum(enumClass = ProductTypeEnum.class)
    @Schema(description = "Valores disponiveis [DIGITAL, FISICO]", defaultValue = "DIGITAL")
    private String type;

    @JsonProperty("isOnPromotion")
    @Schema(description = "Flag para habilitar dizer se o produto esta em promoção", defaultValue = "10")
    private boolean isOnPromotion = false;

    @NotNull
    @Valid
    private MeasurementDto measurement;

    @AllArgsConstructor
    @Data
    public static class MeasurementDto {

        @Schema(description = "Valor do Peso do produto", defaultValue = "10")
        @NotZeroAndNotNullConstraint
        @Positive
        private BigDecimal value;
    }
}
