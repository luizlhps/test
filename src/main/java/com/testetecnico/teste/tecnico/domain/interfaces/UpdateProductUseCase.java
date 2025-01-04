package com.testetecnico.teste.tecnico.domain.interfaces;

import com.testetecnico.teste.tecnico.application.dtos.Product.GetByUuidProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.GetByUuidProductOutputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.UpdateProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.UpdateProductOutputDto;
import com.testetecnico.teste.tecnico.shared.exceptions.NotFoundException;

public interface UpdateProductUseCase {
    UpdateProductOutputDto execute(UpdateProductInputDto input) throws NotFoundException;
}
