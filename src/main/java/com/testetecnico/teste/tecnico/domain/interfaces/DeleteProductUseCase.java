package com.testetecnico.teste.tecnico.domain.interfaces;


import com.testetecnico.teste.tecnico.application.dtos.Product.DeleteProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.DeleteProductOutputDto;
import com.testetecnico.teste.tecnico.shared.exceptions.NotFoundException;

public interface DeleteProductUseCase {
    DeleteProductOutputDto execute(DeleteProductInputDto input) throws NotFoundException;
}
