package com.testetecnico.teste.tecnico.domain.interfaces;

import com.testetecnico.teste.tecnico.application.dtos.Product.GetMostExpensiveProductInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.GetMostExpensiveProductOutputDto;
import com.testetecnico.teste.tecnico.shared.exceptions.NotFoundException;
import org.springframework.data.domain.Page;

public interface GetMostExpensiveProductUseCase {
    GetMostExpensiveProductOutputDto execute(GetMostExpensiveProductInputDto input) throws NotFoundException;
}
