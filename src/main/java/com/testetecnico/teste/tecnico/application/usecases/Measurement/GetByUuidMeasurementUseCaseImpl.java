package com.testetecnico.teste.tecnico.application.usecases.Measurement;

import com.testetecnico.teste.tecnico.application.dtos.Measurement.GetByUuidMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.GetByUuidMeasurementOutputDto;
import com.testetecnico.teste.tecnico.application.gateway.MeasurementGateway;
import com.testetecnico.teste.tecnico.domain.entity.Measurement;
import com.testetecnico.teste.tecnico.domain.interfaces.GetByUuidMeasurementUseCase;
import org.modelmapper.ModelMapper;

public class GetByUuidMeasurementUseCaseImpl implements GetByUuidMeasurementUseCase {
    private final MeasurementGateway measurementGateway;
    private final ModelMapper modelMapper;

    public GetByUuidMeasurementUseCaseImpl(MeasurementGateway measurementGateway, ModelMapper modelMapper) {
        this.measurementGateway = measurementGateway;
        this.modelMapper = modelMapper;
    }


    @Override
    public GetByUuidMeasurementOutputDto execute(GetByUuidMeasurementInputDto input) {
        var measurement = modelMapper.map(input, Measurement.class);

        var measurementFound = measurementGateway.getByUuidMeasurement(measurement);

        if (measurementFound == null) {
            return null;
        }

        return modelMapper.map(measurementFound, GetByUuidMeasurementOutputDto.class);
    }
}
