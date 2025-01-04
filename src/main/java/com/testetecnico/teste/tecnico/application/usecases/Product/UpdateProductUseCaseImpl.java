package com.testetecnico.teste.tecnico.application.usecases.Product;

import com.testetecnico.teste.tecnico.application.dtos.Measurement.DeleteMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.UpdateMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.UpdateMeasurementOutputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.DeleteProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.DeleteProductOutputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.UpdateProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.UpdateProductOutputDto;
import com.testetecnico.teste.tecnico.application.gateway.ProductGateway;
import com.testetecnico.teste.tecnico.domain.entity.Measurement;
import com.testetecnico.teste.tecnico.domain.entity.Product;
import com.testetecnico.teste.tecnico.domain.enums.ProductTypeEnum;
import com.testetecnico.teste.tecnico.domain.enums.UnitEnum;
import com.testetecnico.teste.tecnico.domain.interfaces.UpdateMeasurementUseCase;
import com.testetecnico.teste.tecnico.domain.interfaces.UpdateProductUseCase;
import com.testetecnico.teste.tecnico.shared.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {
    private final ProductGateway productGateway;
    private final ModelMapper modelMapper;
    private final UpdateMeasurementUseCase updateMeasurementUseCase;

    public UpdateProductUseCaseImpl(ProductGateway productGateway, ModelMapper modelMapper, UpdateMeasurementUseCase updateMeasurementUseCase) {
        this.productGateway = productGateway;
        this.modelMapper = modelMapper;
        this.updateMeasurementUseCase = updateMeasurementUseCase;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UpdateProductOutputDto execute(UpdateProductInputDto input) throws NotFoundException {
        var product = modelMapper.map(input, Product.class);

        Product productFound = validateProductExists(product);

        modelMapper.map(input, productFound);

        productFound.calculateValues(
                input.getMeasurement().getValue()
        );

        productFound.getMeasurement().setUnit(
                ProductTypeEnum.valueOf(input.getType()).equals(ProductTypeEnum.FISICO)
                        ? UnitEnum.KG
                        : UnitEnum.MB);

        UpdateMeasurementOutputDto updateMeasurementOutputDto = updateMeasurement(productFound.getMeasurement());

        modelMapper.map(updateMeasurementOutputDto, productFound.getMeasurement());

        var productUpdated = productGateway.updateProduct(productFound);

        return modelMapper.map(productUpdated, UpdateProductOutputDto.class);
    }

    private Product validateProductExists(Product product) throws NotFoundException {
        var productFound = productGateway.getByUuidProduct(product);
        if (productFound == null) {
            throw new NotFoundException("Produto não encontrado", "PRODUCT_NOT_FOUND");
        }
        return productFound;
    }

    private UpdateMeasurementOutputDto updateMeasurement(Measurement measurement) throws NotFoundException {
        var updateMeasurementInputDto = new UpdateMeasurementInputDto(
                measurement.getUuid(),
                measurement.getValue(),
                measurement.getUnit()
        );


        return updateMeasurementUseCase.execute(updateMeasurementInputDto);
    }

}
