package com.testetecnico.teste.tecnico.domain.specifications;

import com.testetecnico.teste.tecnico.domain.entity.Product;
import com.testetecnico.teste.tecnico.domain.enums.ProductTypeEnum;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductSpecification {

    public static Specification<Product> greaterThanOrEqualTotalValue(BigDecimal greaterThanOrEqualTo) {
        return ((root, query, builder) -> greaterThanOrEqualTo == null
                ? null
                : builder.greaterThanOrEqualTo(root.get("totalValue"), greaterThanOrEqualTo));
    }

    public static Specification<Product> lessThanOrEqualTo(BigDecimal lessThanOrEqualTo) {
        return ((root, query, builder) -> lessThanOrEqualTo == null
                ? null
                : builder.lessThanOrEqualTo(root.get("totalValue"), lessThanOrEqualTo));
    }

    public static Specification<Product> isOnPromotion(Boolean isOnPromotion) {
        return (root, query, builder) -> isOnPromotion == null
                ? null
                : builder.equal(root.get("isOnPromotion"), isOnPromotion);
    }

    public static Specification<Product> hasNameContainsWith(String name) {
        return (root, query, builder) -> name == null
                ? null
                : builder.like(builder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Product> hasType(ProductTypeEnum type) {
        return (root, query, builder) -> type == null
                ? null
                : builder.equal(root.get("type"), type);
    }

    public static Specification<Product> noDeleted(Boolean noDeleted) {
        return (root, query, builder) -> noDeleted == null
                ? null
                : builder.equal(root.get("isDeleted"), noDeleted);
    }

}
