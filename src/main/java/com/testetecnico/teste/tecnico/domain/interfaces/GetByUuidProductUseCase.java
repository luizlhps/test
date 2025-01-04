package com.testetecnico.teste.tecnico.domain.interfaces;

import com.testetecnico.teste.tecnico.application.dtos.Measurement.DeleteMeasurementInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Measurement.DeleteMeasurementOutputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.GetByUuidProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.GetByUuidProductOutputDto;

public interface GetByUuidProductUseCase {
    GetByUuidProductOutputDto execute(GetByUuidProductInputDto input);
}
