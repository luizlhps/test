package com.testetecnico.teste.tecnico.adapters.web.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testetecnico.teste.tecnico.application.dtos.Product.*;
import com.testetecnico.teste.tecnico.domain.interfaces.*;
import com.testetecnico.teste.tecnico.shared.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final GetAllProductUseCase getAllProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final GetMostExpensiveProductUseCase getMostExpensiveProductUseCase;
    private final GetAverageProductPriceUseCase getAverageProductPriceUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, GetAllProductUseCase getAllProductUseCase, DeleteProductUseCase deleteProductUseCase, UpdateProductUseCase updateProductUseCase, GetMostExpensiveProductUseCase getMostExpensiveProductUseCase, GetAverageProductPriceUseCase getAverageProductPriceUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.getAllProductUseCase = getAllProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.getMostExpensiveProductUseCase = getMostExpensiveProductUseCase;
        this.getAverageProductPriceUseCase = getAverageProductPriceUseCase;
    }


    @PostMapping()
    public ResponseEntity<CreateProductOutputDto> create(@RequestBody @Valid CreateProductInputDto input) {
        var createProductOutputDto = createProductUseCase.execute(input);

        var uri = UriComponentsBuilder.fromPath("/product/{uuid}")
                .buildAndExpand(createProductOutputDto.getUuid())
                .toUri();

        return ResponseEntity.created(uri).body(createProductOutputDto);
    }

    @GetMapping()
    public ResponseEntity<Page<GetAllProductOutputDto>> getAll
            (@RequestParam(required = false) String type,
             @RequestParam(required = false) String name,
             @RequestParam(required = false) @Positive BigDecimal greaterThanOrEqualTotalValue,
             @RequestParam(required = false) @Positive BigDecimal lessThanOrEqualTotalValue,
             @RequestParam(required = false) Boolean isOnPromotion,

             @RequestParam(required = false, defaultValue = "0") @Min(0) int page,
             @RequestParam(required = false, defaultValue = "10") @Min(1) int size,
             @RequestParam(required = false, defaultValue = "createdAt") String sortBy,
             @RequestParam(required = false, defaultValue = "true") boolean ascending
            ) {

        GetAllProductInputDto input = new GetAllProductInputDto(
                page,
                size,
                sortBy,
                ascending,

                type,
                name,
                greaterThanOrEqualTotalValue,
                lessThanOrEqualTotalValue,
                isOnPromotion
        );


        var getAllProductOutputDto = getAllProductUseCase.execute(input);

        return ResponseEntity.ok(getAllProductOutputDto);
    }

    @GetMapping("/most-expensive")
    public ResponseEntity<GetMostExpensiveProductOutputDto> getMostExpensive() throws NotFoundException {

        GetMostExpensiveProductInputDto input = new GetMostExpensiveProductInputDto();
        var getMostExpensiveProductOutputDto = getMostExpensiveProductUseCase.execute(input);

        return ResponseEntity.ok(getMostExpensiveProductOutputDto);
    }

    @GetMapping("/average")
    public ResponseEntity<GetAverageProductPriceOutputDto> getAverageProductPrice() throws NotFoundException {

        var input = new GetAverageProductPriceInputDto();
        var getAverageProductPriceOutputDto = getAverageProductPriceUseCase.execute(input);

        return ResponseEntity.ok(getAverageProductPriceOutputDto);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid, @Valid DeleteProductInputDto input) throws NotFoundException {
        input.setUuid(uuid);
        deleteProductUseCase.execute(input);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<UpdateProductOutputDto> update(@PathVariable UUID uuid, @RequestBody @Valid UpdateProductInputDto input) throws NotFoundException {
        input.setUuid(uuid);

        var updateProductOutputDto = updateProductUseCase.execute(input);

        return ResponseEntity.ok(updateProductOutputDto);
    }
}
