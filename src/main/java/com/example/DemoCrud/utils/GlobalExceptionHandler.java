package com.example.DemoCrud.utils;

import com.example.DemoCrud.model.payload.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

    // Manejo de excepciones genéricas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> handleGeneralException(Exception ex) {
        return ResponseService.errorInResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Manejo de excepciones específicas
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MessageResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseService.errorInResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Manejo de excepciones personalizadas
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseService.errorInResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Manejo de excepciones de tipo MethodNotAllowed
    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<MessageResponse> handleUnsupportedOperationException(UnsupportedOperationException ex) {
        return ResponseService.errorInResponse(ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
