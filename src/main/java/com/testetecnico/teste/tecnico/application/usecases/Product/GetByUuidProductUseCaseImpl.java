package com.testetecnico.teste.tecnico.application.usecases.Product;

import com.testetecnico.teste.tecnico.application.dtos.Measurement.GetByUuidMeasurementOutputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.GetByUuidProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.GetByUuidProductOutputDto;
import com.testetecnico.teste.tecnico.application.gateway.ProductGateway;
import com.testetecnico.teste.tecnico.domain.entity.Measurement;
import com.testetecnico.teste.tecnico.domain.entity.Product;
import com.testetecnico.teste.tecnico.domain.interfaces.GetByUuidProductUseCase;
import org.modelmapper.ModelMapper;

public class GetByUuidProductUseCaseImpl implements GetByUuidProductUseCase {
    private final ProductGateway productGateway;
    private final ModelMapper modelMapper;

    public GetByUuidProductUseCaseImpl(ProductGateway productGateway, ModelMapper modelMapper) {
        this.productGateway = productGateway;
        this.modelMapper = modelMapper;
    }


    @Override
    public GetByUuidProductOutputDto execute(GetByUuidProductInputDto input) {
        var product = modelMapper.map(input, Product.class);

        var productFound = productGateway.getByUuidProduct(product);

        if (productFound == null) {
            return null;
        }

        return modelMapper.map(productFound, GetByUuidProductOutputDto.class);
    }
}
