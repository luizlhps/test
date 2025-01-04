package com.testetecnico.teste.tecnico.application.usecases.Product;

import com.testetecnico.teste.tecnico.application.dtos.Product.GetAllProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.GetAllProductOutputDto;
import com.testetecnico.teste.tecnico.application.gateway.ProductGateway;
import com.testetecnico.teste.tecnico.domain.entity.Product;
import com.testetecnico.teste.tecnico.domain.enums.ProductTypeEnum;
import com.testetecnico.teste.tecnico.domain.interfaces.GetAllProductUseCase;
import com.testetecnico.teste.tecnico.domain.specifications.ProductSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public class GetAllProductUseCaseImpl implements GetAllProductUseCase {

    private final ProductGateway productGateway;
    private final ModelMapper modelMapper;

    public GetAllProductUseCaseImpl(ProductGateway productGateway, ModelMapper modelMapper) {
        this.productGateway = productGateway;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<GetAllProductOutputDto> execute(GetAllProductInputDto input) {
        Specification<Product> specification = Specification.where(null);

        if (input.getGreaterThanOrEqualTotalValue() != null) {
            specification = specification.and(ProductSpecification.greaterThanOrEqualTotalValue(input.getGreaterThanOrEqualTotalValue()));
        }

        if (input.getLessThanOrEqualTotalValue() != null) {
            specification = specification.and(ProductSpecification.lessThanOrEqualTo(input.getLessThanOrEqualTotalValue()));
        }

        if (input.getName() != null && !input.getName().isEmpty()) {
            specification = specification.and(ProductSpecification.hasNameContainsWith(input.getName()));
        }

        if (input.getIsOnPromotion() != null) {
            specification = specification.and(ProductSpecification.isOnPromotion(input.getIsOnPromotion()));
        }

        if (input.getType() != null) {
            specification = specification.and(ProductSpecification.hasType(ProductTypeEnum.valueOf(input.getType())));
        }

        specification = specification.and(ProductSpecification.noDeleted(false));

        Sort sort = Sort.by(input.isAscending() ? Sort.Order.asc(input.getSortBy()) : Sort.Order.desc(input.getSortBy()));
        PageRequest pageRequest = PageRequest.of(Math.max(input.getPage(), 0), Math.max(input.getSize(), 10), sort);


        var products = productGateway.getAllProducts(specification, pageRequest);

        return products.map(product -> {
            var getAllProductOutputDto = modelMapper.map(product, GetAllProductOutputDto.class);
            getAllProductOutputDto.setPriceWithDiscount(product.getPrice().subtract(product.getDiscount()));

            return getAllProductOutputDto;
        });
    }
}
