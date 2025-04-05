package com.example.DemoCrud.utils;

import com.example.DemoCrud.model.payload.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseService {

    public static ResponseEntity<MessageResponse> getSuccessResponse(String message, Object object ) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message(message)
                .data(object)
                .build(),HttpStatus.OK);
    }

    public static ResponseEntity<MessageResponse> createSuccessResponse(String message,Object object ) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message(message)
                .data(object)
                .build(), HttpStatus.CREATED);
    }

    public static ResponseEntity<MessageResponse> updateSuccessResponse(String message,Object object) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message(message)
                .data(object)
                .build(), HttpStatus.CREATED);
    }

    public static ResponseEntity<MessageResponse> deleteSuccessResponse(String message, Object object) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message(message)
                .data(object)
                .build(), HttpStatus.NO_CONTENT);
    }

    public static ResponseEntity<MessageResponse> errorInResponseNotFound(String errorMessage, HttpStatus status) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message(errorMessage)
                .data(null)
                .build(), HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<MessageResponse> errorInResponse(String errorMessage, HttpStatus status) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message(errorMessage)
                .data(null)
                .build(), HttpStatus.NOT_FOUND);
    }
}
