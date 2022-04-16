package com.civil.project.dao;

import com.civil.project.entity.RegistreNaiss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NaissanceRegistreRep_user3 extends JpaRepository<RegistreNaiss, Integer> {
    @Query("select r from RegistreNaiss r where r.annee=:d")
    List<RegistreNaiss> findByDate(@Param("d") String date);
}

