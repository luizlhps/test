package com.testetecnico.teste.tecnico.infra.gateway;

import com.testetecnico.teste.tecnico.application.gateway.ProductGateway;
import com.testetecnico.teste.tecnico.domain.entity.Product;
import com.testetecnico.teste.tecnico.infra.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.validator.constraints.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductRepositoryGateway implements ProductGateway {

    private final ProductRepository productRepository;

    public ProductRepositoryGateway(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getMostExpensiveProduct() {
        return productRepository.findTopByIsDeletedFalseOrderByTotalValueDesc().orElse(null);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getByUuidProduct(Product product) {
        return productRepository.findByUuidAndIsDeletedFalse(product.getUuid()).orElse(null);

    }

    @Override
    public Page<Product> getAllProducts(Specification<Product> spec, PageRequest pageRequest) {
        return productRepository.findAll(spec, pageRequest);
    }

    @Override
    public BigDecimal getAverageProductPrice() {
        return productRepository.findAveragePriceAndIsDeletedFalse().orElse(null);
    }
}
