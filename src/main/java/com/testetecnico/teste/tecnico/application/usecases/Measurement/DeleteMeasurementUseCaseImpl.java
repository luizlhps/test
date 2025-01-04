package com.testetecnico.teste.tecnico.application.usecases.Measurement;

import com.testetecnico.teste.tecnico.application.dtos.Measurement.DeleteMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.DeleteMeasurementOutputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.GetByUuidMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.gateway.MeasurementGateway;
import com.testetecnico.teste.tecnico.domain.entity.Measurement;
import com.testetecnico.teste.tecnico.domain.interfaces.DeleteMeasurementUseCase;
import com.testetecnico.teste.tecnico.domain.interfaces.GetByUuidMeasurementUseCase;
import com.testetecnico.teste.tecnico.shared.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;

public class DeleteMeasurementUseCaseImpl implements DeleteMeasurementUseCase {
    private final MeasurementGateway measurementGateway;
    private final ModelMapper modelMapper;

    public DeleteMeasurementUseCaseImpl(MeasurementGateway measurementGateway, ModelMapper modelMapper) {
        this.measurementGateway = measurementGateway;
        this.modelMapper = modelMapper;
    }

    @Override
    public DeleteMeasurementOutputDto execute(DeleteMeasurementInputDto input) throws NotFoundException {
        var measurement = modelMapper.map(input, Measurement.class);
        var measurementFound = measurementGateway.getByUuidMeasurement(measurement);

        if (measurementFound == null) {

            throw new NotFoundException("Unidade de medição não encontrado", "MEASUREMENT_NOT_FOUND");
        }

        measurementGateway.deleteMeasurement(measurementFound);

        return new DeleteMeasurementOutputDto();
    }
}
