package com.testetecnico.teste.tecnico.domain.interfaces;

import com.testetecnico.teste.tecnico.application.dtos.Product.GetAverageProductPriceInputDto;
import com.testetecnico.teste.tecnico.application.dtos.Product.GetAverageProductPriceOutputDto;
import com.testetecnico.teste.tecnico.shared.exceptions.NotFoundException;

public interface GetAverageProductPriceUseCase {
    GetAverageProductPriceOutputDto execute(GetAverageProductPriceInputDto input) throws NotFoundException;
}
