package com.testetecnico.teste.tecnico.infra.repositories;

import com.testetecnico.teste.tecnico.domain.entity.Measurement;
import com.testetecnico.teste.tecnico.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MeasurementRepository extends JpaRepository<Measurement, UUID> {
    Optional<Measurement> findByUuidAndIsDeletedFalse(UUID MeasurementUUID);
}
