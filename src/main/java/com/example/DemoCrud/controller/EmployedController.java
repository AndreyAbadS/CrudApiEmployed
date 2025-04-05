package com.example.DemoCrud.controller;

import com.example.DemoCrud.model.dto.EmployedDto;
import com.example.DemoCrud.model.payload.MessageResponse;
import com.example.DemoCrud.service.IEmployed;
import com.example.DemoCrud.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employed")
public class EmployedController {
    @Autowired
    private IEmployed employedService;

    @GetMapping("employees")
    public ResponseEntity<MessageResponse> showAllEmployees() throws ResourceNotFoundException {
        return employedService.listAll();
    }

    @GetMapping("employedById/{id}")
    public ResponseEntity<MessageResponse> findEmployedById(@PathVariable Integer id) throws ResourceNotFoundException{
        return employedService.findEmployedById(id);
    }

    @PostMapping("employed")
    public ResponseEntity<MessageResponse> employed(@RequestBody EmployedDto employedDto) throws Exception {
        return employedService.saveEmployed(employedDto);
    }

    @PutMapping("employed/{id}")
    public ResponseEntity<MessageResponse> updateEmployed(@RequestBody  EmployedDto employedDto, @PathVariable Integer id) throws Exception, ResourceNotFoundException {
        return employedService.updateEmployed(employedDto, id);
    }

    @PatchMapping("patch/{id}")
    public ResponseEntity<MessageResponse> patchEmployed(@RequestBody  EmployedDto employedDto, @PathVariable Integer id) throws Exception, ResourceNotFoundException {
        return employedService.patchEmployed(employedDto, id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<MessageResponse> deleteEmployed(@PathVariable Integer id) throws Exception, ResourceNotFoundException {
        return employedService.deleteEmployed(id);
    }

    @PatchMapping("flag/{id}")
    public ResponseEntity<MessageResponse> updateFlag(@PathVariable Integer id) throws Exception{
        return employedService.updateFlag(id);
    }
}
