package com.larramendi.workshopmongo.resources.exceptions;

import com.larramendi.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //Indica que a classe trata possiveis erros nas requisiçoes;
public class ResourceExceptionHandler {

    //Esse metodo vai servir para tratar o ObjectNotFoundException
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(),
                                                status.value(),
                                                "Não encontrado",
                                                e.getMessage(),
                                                request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }


}
