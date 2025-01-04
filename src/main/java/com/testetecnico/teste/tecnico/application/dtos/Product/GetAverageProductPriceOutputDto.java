package com.testetecnico.teste.tecnico.application.dtos.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class GetAverageProductPriceOutputDto {
    private BigDecimal average;
}
