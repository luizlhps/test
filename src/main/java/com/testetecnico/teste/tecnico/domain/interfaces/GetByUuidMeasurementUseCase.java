package com.testetecnico.teste.tecnico.domain.interfaces;

import com.testetecnico.teste.tecnico.application.dtos.Measurement.DeleteMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.DeleteMeasurementOutputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.GetByUuidMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.GetByUuidMeasurementOutputDto;

public interface GetByUuidMeasurementUseCase {
    GetByUuidMeasurementOutputDto execute(GetByUuidMeasurementInputDto input);
}
