package com.testetecnico.teste.tecnico.application.usecases.Product;

import com.testetecnico.teste.tecnico.application.dtos.Measurement.DeleteMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.DeleteMeasurementOutputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.GetByUuidMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.DeleteProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.DeleteProductOutputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.GetByUuidProductInputDto;
import com.testetecnico.teste.tecnico.application.gateway.ProductGateway;
import com.testetecnico.teste.tecnico.domain.entity.Measurement;
import com.testetecnico.teste.tecnico.domain.entity.Product;
import com.testetecnico.teste.tecnico.domain.interfaces.CreateMeasurementUseCase;
import com.testetecnico.teste.tecnico.domain.interfaces.DeleteMeasurementUseCase;
import com.testetecnico.teste.tecnico.domain.interfaces.DeleteProductUseCase;
import com.testetecnico.teste.tecnico.domain.interfaces.GetByUuidProductUseCase;
import com.testetecnico.teste.tecnico.shared.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final ProductGateway productGateway;
    private final ModelMapper modelMapper;
    private final DeleteMeasurementUseCase deleteMeasurementUseCase;

    public DeleteProductUseCaseImpl(ProductGateway productGateway, ModelMapper modelMapper, DeleteMeasurementUseCase deleteMeasurementUseCase) {
        this.productGateway = productGateway;
        this.modelMapper = modelMapper;
        this.deleteMeasurementUseCase = deleteMeasurementUseCase;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DeleteProductOutputDto execute(DeleteProductInputDto input) throws NotFoundException {
        var product = modelMapper.map(input, Product.class);
        var productFound = productGateway.getByUuidProduct(product);

        if (productFound == null) {
            throw new NotFoundException("Produto não encontrado", "PRODUCT_NOT_FOUND");
        }

        productFound.setDeleted(true);

        productGateway.deleteProduct(productFound);

        var deleteMeasurementInputDto = new DeleteMeasurementInputDto(productFound.getMeasurement().getUuid());
        deleteMeasurementUseCase.execute(deleteMeasurementInputDto);

        return new DeleteProductOutputDto();
    }
}
