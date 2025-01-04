package com.testetecnico.teste.tecnico.application.usecases.Measurement;

import com.testetecnico.teste.tecnico.application.dtos.Measurement.UpdateMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.UpdateMeasurementOutputDto;
import com.testetecnico.teste.tecnico.application.gateway.MeasurementGateway;
import com.testetecnico.teste.tecnico.domain.entity.Measurement;
import com.testetecnico.teste.tecnico.domain.interfaces.UpdateMeasurementUseCase;
import com.testetecnico.teste.tecnico.shared.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;

public class UpdateMeasurementUseCaseImpl implements UpdateMeasurementUseCase {
    private final MeasurementGateway measurementGateway;
    private final ModelMapper modelMapper;

    public UpdateMeasurementUseCaseImpl(MeasurementGateway measurementGateway, ModelMapper modelMapper) {
        this.measurementGateway = measurementGateway;
        this.modelMapper = modelMapper;
    }

    @Override
    public UpdateMeasurementOutputDto execute(UpdateMeasurementInputDto input) throws NotFoundException {
        var measurement = modelMapper.map(input, Measurement.class);
        var measurementFound = measurementGateway.getByUuidMeasurement(measurement);

        if (measurementFound == null) {
            throw new NotFoundException("Unidade de medição não encontrado", "MEASUREMENT_NOT_FOUND");
        }

        modelMapper.map(input, measurementFound);

        var measurementUpdated = measurementGateway.updateMeasurement(measurementFound);

        return modelMapper.map(measurementUpdated, UpdateMeasurementOutputDto.class);
    }
}
