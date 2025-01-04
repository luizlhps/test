package com.testetecnico.teste.tecnico.infra.gateway;

import com.testetecnico.teste.tecnico.application.gateway.MeasurementGateway;
import com.testetecnico.teste.tecnico.domain.entity.Measurement;
import com.testetecnico.teste.tecnico.infra.repositories.MeasurementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MeasurementRepositoryGateway implements MeasurementGateway {

    private final MeasurementRepository measurementRepository;

    public MeasurementRepositoryGateway(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Override
    public Measurement createMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    @Override
    public Measurement updateMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    @Override
    public void deleteMeasurement(Measurement measurement) {
        measurement.setDeleted(true);
        measurementRepository.save(measurement);
    }

    @Override
    public Measurement getByUuidMeasurement(Measurement measurement) {
        return measurementRepository.findByUuidAndIsDeletedFalse(measurement.getUuid()).orElse(null);

    }


}
