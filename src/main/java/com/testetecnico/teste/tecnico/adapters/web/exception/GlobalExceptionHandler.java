package com.testetecnico.teste.tecnico.adapters.web.exception;

import com.testetecnico.teste.tecnico.shared.exceptions.CustomException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<RestErrorMessage> handleCustomException(CustomException ex) {
        RestErrorMessage errorResponse = new RestErrorMessage(ex.getStatus(), ex.getMessage(), ex.getCode(), ex);
        return new ResponseEntity<RestErrorMessage>(errorResponse, ex.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestErrorMessage> handleCustomException(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        var fields = new HashMap<String, String>();

        errors.forEach(e -> {
            fields.put(e.getField(), e.getDefaultMessage());
        });

        RestErrorMessage errorResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, "Erro de validação", "BAD_REQUEST", ex, fields);

        return new ResponseEntity<RestErrorMessage>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestErrorMessage> handleGeneralException(Exception ex) {
        RestErrorMessage errorResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno.", "INTERNAL_SERVER_ERROR", ex);
        return new ResponseEntity<RestErrorMessage>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}