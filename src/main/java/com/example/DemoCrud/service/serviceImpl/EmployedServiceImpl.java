package com.example.DemoCrud.service.serviceImpl;

import com.example.DemoCrud.model.dto.EmployedDto;
import com.example.DemoCrud.model.entity.Employed;
import com.example.DemoCrud.model.mappers.EmployedMapper;
import com.example.DemoCrud.model.payload.MessageResponse;
import com.example.DemoCrud.repository.EmployedRepository;
import com.example.DemoCrud.service.IEmployed;
import com.example.DemoCrud.utils.Constants;
import com.example.DemoCrud.utils.ResourceNotFoundException;
import com.example.DemoCrud.utils.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployedServiceImpl implements IEmployed {

    @Autowired
    EmployedRepository employedRepository;

    @Autowired
    EmployedMapper employedMapper;

    @Override
    public ResponseEntity<MessageResponse> listAll() throws ResourceNotFoundException {
        List<Employed> employeesList = (List<Employed>) employedRepository.findAll();
        if (employeesList.isEmpty()) {
            throw new ResourceNotFoundException(Constants.ERROR_LIST);
        }
        return ResponseService.getSuccessResponse(Constants.SUCCESS_LIST, employeesList);
    }

    @Override
    public ResponseEntity<MessageResponse> findEmployedById(Integer id) throws ResourceNotFoundException {
        if (!employedRepository.existsById(id)) {
            throw new ResourceNotFoundException(Constants.ERROR_FIND);
        }
        return ResponseService.getSuccessResponse(Constants.SUCCESS_FIND, employedRepository.findById(id));
    }

    @Transactional
    @Override
    public ResponseEntity<MessageResponse> saveEmployed(EmployedDto employedDto) throws UnsupportedOperationException {
        if (employedDto == null) {
            throw new UnsupportedOperationException(Constants.ERROR_SAVE_EMPLOYED);
        }
        Employed employed = employedMapper.dtoToEntity(employedDto);
        return ResponseService.createSuccessResponse(Constants.SUCCESS_SAVE_EMPLOYED, employedRepository.save(employed));
    }

    @Transactional
    @Override
    public ResponseEntity<MessageResponse> updateEmployed(EmployedDto employedDto, Integer id) throws Exception {
        if (!employedRepository.existsById(id)) {
            throw new ResourceNotFoundException(Constants.ERROR_FIND);
        }
        Employed exist = employedRepository.findById(id).orElseThrow(() -> new Exception(Constants.ERROR_FIND));
        employedMapper.updateEntityToDto(employedDto,exist );
        return ResponseService.updateSuccessResponse(Constants.SUCCESS_UPDATE_EMPLOYED, employedRepository.save(exist));
    }

    @Transactional
    @Override
    public ResponseEntity<MessageResponse> patchEmployed(EmployedDto employedDto, Integer id) throws Exception {
        if (!employedRepository.existsById(id)) {
            throw new ResourceNotFoundException(Constants.ERROR_FIND);
        }
        Employed existEmployed = employedRepository.findById(id).orElseThrow(() -> new Exception(Constants.ERROR_FIND));
        employedMapper.updateEntityToDto(employedDto,existEmployed);
        return ResponseService.updateSuccessResponse(Constants.SUCCESS_UPDATE_EMPLOYED, employedRepository.save(existEmployed));
    }

    @Override
    public ResponseEntity<MessageResponse> deleteEmployed(Integer id) throws Exception {
        if (!employedRepository.existsById(id)){
            throw new ResourceNotFoundException(Constants.ERROR_FIND);
        }
        Employed EmployedDataDelete = employedRepository.findById(id).orElseThrow(() -> new Exception(Constants.ERROR_FIND));
        employedRepository.delete(EmployedDataDelete);
        return ResponseService.deleteSuccessResponse(Constants.SUCCESS_DELETE_EMPLOYED, null);
    }

    @Override
    public ResponseEntity<MessageResponse> updateFlag(Integer id) throws Exception {
        if (!employedRepository.existsById(id)){
            throw new ResourceNotFoundException(Constants.ERROR_FIND);
        }
        return  ResponseService.getSuccessResponse(Constants.SUCCESS_UPDATE_EMPLOYED, employedRepository.updateFlag(id));
    }
}
