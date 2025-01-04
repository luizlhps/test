package com.testetecnico.teste.tecnico.domain.interfaces;

import com.testetecnico.teste.tecnico.application.dtos.Measurement.UpdateMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.UpdateMeasurementOutputDto;
import com.testetecnico.teste.tecnico.shared.exceptions.NotFoundException;

public interface UpdateMeasurementUseCase {
    UpdateMeasurementOutputDto execute(UpdateMeasurementInputDto input) throws NotFoundException;
}
