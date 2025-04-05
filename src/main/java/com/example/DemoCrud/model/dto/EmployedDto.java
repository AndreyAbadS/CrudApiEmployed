package com.example.DemoCrud.model.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class EmployedDto {
    private Integer idEmployed;
    private String nameEmployed;
    private String lastNameEmployed;
    private String addressEmployed;
    private Integer ageEmployed;
    private Integer flagEmployed;
    private String rfcEmployed;
}