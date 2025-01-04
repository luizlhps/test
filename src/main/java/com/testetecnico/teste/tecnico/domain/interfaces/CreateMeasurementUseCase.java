package com.testetecnico.teste.tecnico.domain.interfaces;

import com.testetecnico.teste.tecnico.application.dtos.Measurement.CreateMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.CreateMeasurementOutputDto;

public interface CreateMeasurementUseCase {
    CreateMeasurementOutputDto execute(CreateMeasurementInputDto input);
}
