package com.example.DemoCrud.model.mappers;

import com.example.DemoCrud.model.dto.EmployedDto;
import com.example.DemoCrud.model.entity.Employed;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-04T16:06:31-0600",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EmployedMapperImpl implements EmployedMapper {

    @Override
    public Employed dtoToEntity(EmployedDto employedDto) {
        if ( employedDto == null ) {
            return null;
        }

        Employed employed = new Employed();

        employed.setNameEmployed( employedDto.getNameEmployed() );
        employed.setLastNameEmployed( employedDto.getLastNameEmployed() );
        employed.setAddressEmployed( employedDto.getAddressEmployed() );
        if ( employedDto.getAgeEmployed() != null ) {
            employed.setAgeEmployed( String.valueOf( employedDto.getAgeEmployed() ) );
        }
        if ( employedDto.getFlagEmployed() != null ) {
            employed.setFlagEmployed( String.valueOf( employedDto.getFlagEmployed() ) );
        }
        employed.setRfcEmployed( employedDto.getRfcEmployed() );

        return employed;
    }

    @Override
    public void updateEntityToDto(EmployedDto dto, Employed entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getIdEmployed() != null ) {
            entity.setIdEmployed( dto.getIdEmployed() );
        }
        if ( dto.getNameEmployed() != null ) {
            entity.setNameEmployed( dto.getNameEmployed() );
        }
        if ( dto.getLastNameEmployed() != null ) {
            entity.setLastNameEmployed( dto.getLastNameEmployed() );
        }
        if ( dto.getAddressEmployed() != null ) {
            entity.setAddressEmployed( dto.getAddressEmployed() );
        }
        if ( dto.getAgeEmployed() != null ) {
            entity.setAgeEmployed( String.valueOf( dto.getAgeEmployed() ) );
        }
        if ( dto.getFlagEmployed() != null ) {
            entity.setFlagEmployed( String.valueOf( dto.getFlagEmployed() ) );
        }
        if ( dto.getRfcEmployed() != null ) {
            entity.setRfcEmployed( dto.getRfcEmployed() );
        }
    }
}
