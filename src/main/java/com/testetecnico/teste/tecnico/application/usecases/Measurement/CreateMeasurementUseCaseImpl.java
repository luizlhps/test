package com.testetecnico.teste.tecnico.application.usecases.Measurement;


import com.testetecnico.teste.tecnico.application.dtos.Measurement.CreateMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.CreateMeasurementOutputDto;
import com.testetecnico.teste.tecnico.application.gateway.MeasurementGateway;
import com.testetecnico.teste.tecnico.domain.entity.Measurement;
import com.testetecnico.teste.tecnico.domain.interfaces.CreateMeasurementUseCase;
import org.modelmapper.ModelMapper;

public class CreateMeasurementUseCaseImpl implements CreateMeasurementUseCase {
    private final MeasurementGateway measurementGateway;
    private final ModelMapper modelMapper;

    public CreateMeasurementUseCaseImpl(MeasurementGateway measurementGateway, ModelMapper modelMapper) {
        this.measurementGateway = measurementGateway;
        this.modelMapper = modelMapper;
    }

    @Override
    public CreateMeasurementOutputDto execute(CreateMeasurementInputDto input) {
        var measurement = modelMapper.map(input, Measurement.class);

        var measurementCreated = measurementGateway.createMeasurement(measurement);

        return modelMapper.map(measurementCreated, CreateMeasurementOutputDto.class);
    }
}
