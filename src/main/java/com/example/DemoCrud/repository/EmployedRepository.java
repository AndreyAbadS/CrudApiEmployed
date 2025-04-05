package com.example.DemoCrud.repository;

import com.example.DemoCrud.model.entity.Employed;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployedRepository extends CrudRepository<Employed, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_employed as e SET e.flag_employed = 1 WHERE e.id_employed = :id", nativeQuery = true)
    Integer updateFlag(@Param("id") Integer id);
}
