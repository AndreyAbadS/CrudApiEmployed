package com.example.DemoCrud.service;

import com.example.DemoCrud.model.dto.EmployedDto;
import com.example.DemoCrud.model.payload.MessageResponse;
import com.example.DemoCrud.utils.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface IEmployed {
    ResponseEntity<MessageResponse> listAll() throws ResourceNotFoundException;

    ResponseEntity<MessageResponse> findEmployedById(Integer id) throws ResourceNotFoundException;

    ResponseEntity<MessageResponse> saveEmployed(EmployedDto employedDto) throws UnsupportedOperationException;

    ResponseEntity<MessageResponse> updateEmployed(EmployedDto employedDto, Integer id) throws Exception, ResourceNotFoundException;

    ResponseEntity<MessageResponse> patchEmployed(EmployedDto employedDto, Integer id) throws Exception, ResourceNotFoundException;

    ResponseEntity<MessageResponse> deleteEmployed(Integer id) throws Exception, ResourceNotFoundException;

    ResponseEntity<MessageResponse> updateFlag(Integer id) throws Exception;
}
