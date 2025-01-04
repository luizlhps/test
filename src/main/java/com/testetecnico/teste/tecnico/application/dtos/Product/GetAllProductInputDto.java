package com.testetecnico.teste.tecnico.application.dtos.Product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testetecnico.teste.tecnico.adapters.web.validations.ValueOfEnum;
import com.testetecnico.teste.tecnico.domain.enums.ProductTypeEnum;
import com.testetecnico.teste.tecnico.shared.dtos.QueryFilterDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
public class GetAllProductInputDto extends QueryFilterDto {

    @ValueOfEnum(enumClass = ProductTypeEnum.class)
    @Schema(description = "Valores disponiveis [DIGITAL, FISICO]", defaultValue = "DIGITAL")
    private String type;

    private String name;

    @Positive
    private BigDecimal greaterThanOrEqualTotalValue;

    @Positive
    private BigDecimal lessThanOrEqualTotalValue;

    @JsonProperty("isOnPromotion")
    private Boolean isOnPromotion;

    public GetAllProductInputDto(int page, int size, String sortBy, boolean ascending, String type, String name, BigDecimal greaterThanOrEqualTotalValue, BigDecimal lessThanOrEqualTotalValue, Boolean isOnPromotion) {
        super(page, size, sortBy, ascending);
        this.type = type;
        this.name = name;
        this.greaterThanOrEqualTotalValue = greaterThanOrEqualTotalValue;
        this.lessThanOrEqualTotalValue = lessThanOrEqualTotalValue;
        this.isOnPromotion = isOnPromotion;
    }
}