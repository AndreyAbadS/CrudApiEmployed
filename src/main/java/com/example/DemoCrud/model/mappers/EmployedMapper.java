package com.example.DemoCrud.model.mappers;

import com.example.DemoCrud.model.dto.EmployedDto;
import com.example.DemoCrud.model.entity.Employed;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EmployedMapper {


    @Mapping(target = "idEmployed", ignore = true)
    Employed dtoToEntity(EmployedDto employedDto);

    // Mapear solo los campos que se desean actualizar, si son no nulos
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityToDto(EmployedDto dto, @MappingTarget Employed entity);
}

