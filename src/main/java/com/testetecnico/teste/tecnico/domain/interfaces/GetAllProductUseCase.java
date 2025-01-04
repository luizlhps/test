package com.testetecnico.teste.tecnico.domain.interfaces;

import com.testetecnico.teste.tecnico.application.dtos.Product.GetAllProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.GetAllProductOutputDto;
import org.springframework.data.domain.Page;

public interface GetAllProductUseCase {
    Page<GetAllProductOutputDto> execute(GetAllProductInputDto input);
}
