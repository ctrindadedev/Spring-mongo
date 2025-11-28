package com.ctrindadedev.mongodb_spring.resources.exception;

import com.ctrindadedev.mongodb_spring.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        //(404);
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError(System.currentTimeMillis(), "Não encontrado", request.getRequestURI(), status.value(), e.getMessage());

        //Controla manualmente o status declarado antes
        return ResponseEntity.status(status).body(error);
    }



}
