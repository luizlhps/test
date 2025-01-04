package com.testetecnico.teste.tecnico.application.usecases.Product;

import com.testetecnico.teste.tecnico.application.dtos.Product.GetAverageProductPriceInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.GetAverageProductPriceOutputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.GetMostExpensiveProductOutputDto;
import com.testetecnico.teste.tecnico.application.gateway.ProductGateway;
import com.testetecnico.teste.tecnico.domain.entity.Product;
import com.testetecnico.teste.tecnico.domain.interfaces.GetAverageProductPriceUseCase;
import com.testetecnico.teste.tecnico.shared.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

public class GetAverageProductPriceUseCaseImpl implements GetAverageProductPriceUseCase {
    private final ProductGateway productGateway;
    private final ModelMapper modelMapper;

    public GetAverageProductPriceUseCaseImpl(ProductGateway productGateway, ModelMapper modelMapper) {
        this.productGateway = productGateway;
        this.modelMapper = modelMapper;
    }

    @Override
    public GetAverageProductPriceOutputDto execute(GetAverageProductPriceInputDto input) throws NotFoundException {
        BigDecimal average = productGateway.getAverageProductPrice();

        if (average == null) {
            throw new NotFoundException("Nenhum produto encontrado, registre algum produto para continuar", "PRODUCT_NOT_FOUND");
        }

        return new GetAverageProductPriceOutputDto(average);
    }
}
