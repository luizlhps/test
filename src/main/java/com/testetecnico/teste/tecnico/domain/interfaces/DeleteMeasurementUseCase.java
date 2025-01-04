package com.testetecnico.teste.tecnico.domain.interfaces;

import com.testetecnico.teste.tecnico.application.dtos.Measurement.DeleteMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.DeleteMeasurementOutputDto;
import com.testetecnico.teste.tecnico.shared.exceptions.NotFoundException;

public interface DeleteMeasurementUseCase {
    DeleteMeasurementOutputDto execute(DeleteMeasurementInputDto input) throws NotFoundException;
}
