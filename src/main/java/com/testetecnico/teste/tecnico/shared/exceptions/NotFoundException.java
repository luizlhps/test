package com.testetecnico.teste.tecnico.shared.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends CustomException {
    private final HttpStatus status;
    private final String code;

    public NotFoundException(String message, String code) {
        super(message);
        this.status = HttpStatus.NOT_FOUND;
        this.code = code;
    }
}
