package com.testetecnico.teste.tecnico.infra.repositories;

import com.testetecnico.teste.tecnico.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID>, JpaSpecificationExecutor<Product> {
    Optional<Product> findByUuidAndIsDeletedFalse(UUID productUUID);

    Optional<Product> findTopByIsDeletedFalseOrderByTotalValueDesc();

    @Query("SELECT AVG(p.price) FROM Product p WHERE p.isDeleted = false")
    Optional<BigDecimal> findAveragePriceAndIsDeletedFalse();
}
