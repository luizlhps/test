package com.testetecnico.teste.tecnico.domain.interfaces;

import com.testetecnico.teste.tecnico.application.dtos.Product.CreateProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.CreateProductOutputDto;

public interface CreateProductUseCase {
    CreateProductOutputDto execute(CreateProductInputDto input);
}
