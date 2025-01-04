package com.testetecnico.teste.tecnico.application.usecases.Product;


import com.testetecnico.teste.tecnico.application.dtos.Measurement.CreateMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.CreateProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.CreateProductOutputDto;
import com.testetecnico.teste.tecnico.application.gateway.ProductGateway;
import com.testetecnico.teste.tecnico.domain.entity.Measurement;
import com.testetecnico.teste.tecnico.domain.entity.Product;
import com.testetecnico.teste.tecnico.domain.enums.ProductTypeEnum;
import com.testetecnico.teste.tecnico.domain.enums.UnitEnum;
import com.testetecnico.teste.tecnico.domain.interfaces.CreateMeasurementUseCase;
import com.testetecnico.teste.tecnico.domain.interfaces.CreateProductUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

public class CreateProductUseCaseImpl implements CreateProductUseCase {
    private final ProductGateway productGateway;
    private final ModelMapper modelMapper;
    private final CreateMeasurementUseCase createMeasurementUseCase;

    public CreateProductUseCaseImpl(ProductGateway productGateway, ModelMapper modelMapper, CreateMeasurementUseCase createMeasurementUseCase) {
        this.productGateway = productGateway;
        this.modelMapper = modelMapper;
        this.createMeasurementUseCase = createMeasurementUseCase;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public CreateProductOutputDto execute(CreateProductInputDto input) {
        final var TEN_PERCENT = "0.1";
        final var discount = new BigDecimal(TEN_PERCENT);

        Product product = modelMapper.map(input, Product.class);
        product.setDiscount(input.isOnPromotion() ? discount : BigDecimal.ZERO);
        product.setPrice(input.getPrice());
        product.setOnPromotion(input.isOnPromotion());

        Measurement measurement = createMeasurement(input);

        product.setMeasurement(measurement);

        product.calculateValues(
                input.getMeasurement().getValue()
        );

        var productCreated = productGateway.createProduct(product);

        return modelMapper.map(productCreated, CreateProductOutputDto.class);
    }

    private Measurement createMeasurement(CreateProductInputDto input) {
        var createMeasurementInputDto = new CreateMeasurementInputDto(
                input.getMeasurement().getValue(),
                ProductTypeEnum.valueOf(input.getType()).equals(ProductTypeEnum.FISICO)
                        ? UnitEnum.KG
                        : UnitEnum.MB
        );
        var measurementCreated = createMeasurementUseCase.execute(createMeasurementInputDto);

        return modelMapper.map(measurementCreated, Measurement.class);
    }

}
