package com.testetecnico.teste.tecnico.application.dtos.Product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testetecnico.teste.tecnico.adapters.web.validations.NotZeroAndNotNullConstraint;
import com.testetecnico.teste.tecnico.adapters.web.validations.ValueOfEnum;
import com.testetecnico.teste.tecnico.domain.enums.ProductTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Data
public class CreateProductInputDto {

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
