package com.testetecnico.teste.tecnico.application.dtos.Product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testetecnico.teste.tecnico.adapters.web.validations.NotZeroAndNotNullConstraint;
import com.testetecnico.teste.tecnico.adapters.web.validations.ValueOfEnum;
import com.testetecnico.teste.tecnico.domain.enums.ProductTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
public class DeleteProductInputDto {

    @NotNull
    private UUID uuid;
}
