package com.example.DemoCrud.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.mapstruct.Builder;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tbl_employed")
public class Employed implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employed")
    private Integer idEmployed;

    @Column(name = "name_employed")
    private String nameEmployed;

    @Column(name = "last_name_employed")
    private String lastNameEmployed;

    @Column(name = "address_employed")
    private String addressEmployed;

    @Column(name = "age_employed")
    private String ageEmployed;

    @Column(name = "flag_employed")
    private String flagEmployed;

    @Column(name = "rfc_employed")
    private String rfcEmployed;
}
