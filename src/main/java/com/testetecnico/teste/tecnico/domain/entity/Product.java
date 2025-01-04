package com.testetecnico.teste.tecnico.domain.entity;


import com.testetecnico.teste.tecnico.domain.enums.ProductTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @NotNull
    private BigDecimal price;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ProductTypeEnum type;

    @NotNull
    private BigDecimal shipping;

    @NotNull
    private BigDecimal discount;

    @NotNull
    private BigDecimal totalValue;

    @NotNull
    private BigDecimal priceWithDiscount;

    @NotNull
    @Column(name = "is_on_promotion", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isOnPromotion;

    @NotNull
    private String name;

    @OneToOne()
    @JoinColumn(name = "measurement_uuid", referencedColumnName = "uuid")
    private Measurement measurement;

    @CreationTimestamp
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    @NotNull
    @Column(name = "is_deleted", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isDeleted;


    public Product() {
    }

    public Product(UUID uuid, BigDecimal price, ProductTypeEnum type, BigDecimal shipping, BigDecimal discount, BigDecimal totalValue, boolean isOnPromotion, String name, Measurement measurement, OffsetDateTime createdAt, OffsetDateTime updatedAt, boolean isDeleted) {
        this.uuid = uuid;
        this.price = price;
        this.type = type;
        this.shipping = shipping;
        this.discount = discount;
        this.totalValue = totalValue;
        this.isOnPromotion = isOnPromotion;
        this.name = name;
        this.measurement = measurement;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(uuid, product.uuid);
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductTypeEnum getType() {
        return this.type;
    }

    public void setType(ProductTypeEnum type) {
        this.type = type;
    }

    public BigDecimal getShipping() {
        return this.shipping;
    }

    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    public BigDecimal getDiscount() {
        return this.discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalValue() {
        return this.totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getPriceWithDiscount() {
        return this.priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public boolean isOnPromotion() {
        return this.isOnPromotion;
    }

    public void setOnPromotion(boolean onPromotion) {
        this.isOnPromotion = onPromotion;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Measurement getMeasurement() {
        return this.measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setDeleted(boolean deleted) {
        this.isDeleted = deleted;
    }

    private static final BigDecimal SHIPPING_VALUE = BigDecimal.valueOf(10);

    private BigDecimal calculatePriceShipping(String type, BigDecimal measurementValue) {
        return ProductTypeEnum.valueOf(type).equals(ProductTypeEnum.FISICO)
                ? measurementValue.multiply(SHIPPING_VALUE)
                : BigDecimal.ZERO;
    }

    private BigDecimal calculateValueProductWithDiscount(BigDecimal price, boolean isOnPromotion, BigDecimal discount) {
        return isOnPromotion
                ? price.subtract(price.multiply(discount))
                : price;
    }

    public void calculateValues(BigDecimal measurementValue) {
        this.shipping = this.calculatePriceShipping(this.type.name(), measurementValue);
        this.priceWithDiscount = this.calculateValueProductWithDiscount(this.price, this.isOnPromotion, this.discount);
        this.totalValue = this.shipping.add(this.priceWithDiscount);
    }
}
