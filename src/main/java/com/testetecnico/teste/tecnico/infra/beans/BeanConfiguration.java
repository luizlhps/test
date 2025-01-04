package com.testetecnico.teste.tecnico.infra.beans;

import com.testetecnico.teste.tecnico.application.gateway.MeasurementGateway;
import com.testetecnico.teste.tecnico.application.gateway.ProductGateway;
import com.testetecnico.teste.tecnico.application.usecases.Measurement.CreateMeasurementUseCaseImpl;
import com.testetecnico.teste.tecnico.application.usecases.Measurement.DeleteMeasurementUseCaseImpl;
import com.testetecnico.teste.tecnico.application.usecases.Measurement.GetByUuidMeasurementUseCaseImpl;
import com.testetecnico.teste.tecnico.application.usecases.Measurement.UpdateMeasurementUseCaseImpl;
import com.testetecnico.teste.tecnico.application.usecases.Product.*;
import com.testetecnico.teste.tecnico.domain.interfaces.*;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Teste Técnico")
                        .description("Visualização da api")
                        .version("1.0.0"));
    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CreateMeasurementUseCase createMeasurementUseCase(MeasurementGateway measurementGateway, ModelMapper modelMapper) {
        return new CreateMeasurementUseCaseImpl(measurementGateway, modelMapper);
    }

    @Bean
    public UpdateMeasurementUseCase updateMeasurementUseCase(MeasurementGateway measurementGateway, ModelMapper modelMapper) {
        return new UpdateMeasurementUseCaseImpl(measurementGateway, modelMapper);
    }

    @Bean
    public GetByUuidMeasurementUseCase getByUuidMeasurementUseCase(
            MeasurementGateway measurementGateway
            , ModelMapper modelMapper
    ) {
        return new GetByUuidMeasurementUseCaseImpl(measurementGateway, modelMapper);
    }


    @Bean
    public DeleteMeasurementUseCase deleteMeasurementUseCase(
            MeasurementGateway measurementGateway
            , ModelMapper modelMapper
    ) {
        return new DeleteMeasurementUseCaseImpl(measurementGateway, modelMapper);
    }


    @Bean
    public CreateProductUseCase createProductUseCase(ProductGateway productGateway
            , ModelMapper modelMapper
            , CreateMeasurementUseCase createMeasurementUseCase
    ) {
        return new CreateProductUseCaseImpl(productGateway, modelMapper, createMeasurementUseCase);
    }


    @Bean
    public GetAllProductUseCase getAllProductUseCase(ProductGateway productGateway, ModelMapper modelMapper) {
        return new GetAllProductUseCaseImpl(productGateway, modelMapper);
    }

    @Bean
    public GetMostExpensiveProductUseCase getMostExpensiveProductUseCase(ProductGateway productGateway, ModelMapper modelMapper) {
        return new GetMostExpensiveProductUseCaseImpl(productGateway, modelMapper);
    }

    @Bean
    public GetAverageProductPriceUseCase getAverageProductPriceUseCase(ProductGateway productGateway, ModelMapper modelMapper) {
        return new GetAverageProductPriceUseCaseImpl(productGateway, modelMapper);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase(ProductGateway productGateway
            , ModelMapper modelMapper
            , UpdateMeasurementUseCase updateMeasurementUseCase
    ) {
        return new UpdateProductUseCaseImpl(productGateway, modelMapper, updateMeasurementUseCase);
    }

    @Bean
    public GetByUuidProductUseCase getByUuidProductUseCase(
            ProductGateway measurementGateway
            , ModelMapper modelMapper
    ) {
        return new GetByUuidProductUseCaseImpl(measurementGateway, modelMapper);
    }


    @Bean
    public DeleteProductUseCase deleteProductUseCase(
            ProductGateway measurementGateway
            , ModelMapper modelMapper
            , DeleteMeasurementUseCase deleteMeasurementUseCase
    ) {
        return new DeleteProductUseCaseImpl(measurementGateway, modelMapper, deleteMeasurementUseCase);
    }

}