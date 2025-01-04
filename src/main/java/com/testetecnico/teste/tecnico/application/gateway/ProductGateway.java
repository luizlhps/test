package com.testetecnico.teste.tecnico.application.gateway;

import com.testetecnico.teste.tecnico.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.List;

public interface ProductGateway {
    Product createProduct(Product product);

    BigDecimal getAverageProductPrice();

    Product getMostExpensiveProduct();

    Product updateProduct(Product product);

    void deleteProduct(Product product);

    Product getByUuidProduct(Product product);

    Page<Product> getAllProducts(Specification<Product> spec, PageRequest pageRequest);
}
