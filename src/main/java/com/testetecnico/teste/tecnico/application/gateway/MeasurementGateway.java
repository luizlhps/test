package com.testetecnico.teste.tecnico.application.gateway;

import com.testetecnico.teste.tecnico.domain.entity.Measurement;
import com.testetecnico.teste.tecnico.domain.entity.Product;

import java.util.List;

public interface MeasurementGateway {
    Measurement createMeasurement(Measurement measurement);

    Measurement updateMeasurement(Measurement measurement);

    void deleteMeasurement(Measurement measurement);

    Measurement getByUuidMeasurement(Measurement measurement);
}
