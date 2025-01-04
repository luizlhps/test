package com.testetecnico.teste.tecnico.application.usecases.Product;

import com.testetecnico.teste.tecnico.application.dtos.Product.GetMostExpensiveProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.GetMostExpensiveProductOutputDto;
import com.testetecnico.teste.tecnico.application.gateway.ProductGateway;
import com.testetecnico.teste.tecnico.domain.interfaces.CreateMeasurementUseCase;
import com.testetecnico.teste.tecnico.domain.interfaces.GetMostExpensiveProductUseCase;
import com.testetecnico.teste.tecnico.shared.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

public class GetMostExpensiveProductUseCaseImpl implements GetMostExpensiveProductUseCase {
    private final ProductGateway productGateway;
    private final ModelMapper modelMapper;

    public GetMostExpensiveProductUseCaseImpl(ProductGateway productGateway, ModelMapper modelMapper) {
        this.productGateway = productGateway;
        this.modelMapper = modelMapper;
    }

    @Override
    public GetMostExpensiveProductOutputDto execute(GetMostExpensiveProductInputDto input) throws NotFoundException {
        var product = productGateway.getMostExpensiveProduct();

        if (product == null) {
            throw new NotFoundException("Nenhum produto encontrado, registre algum produto para continuar", "PRODUCT_NOT_FOUND");
        }

        return modelMapper.map(product, GetMostExpensiveProductOutputDto.class);
    }
}
