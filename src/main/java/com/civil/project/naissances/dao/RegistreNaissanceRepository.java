package com.civil.project.naissances.dao;

import com.civil.project.naissances.entity.RegistreNaiss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistreNaissanceRepository extends JpaRepository<RegistreNaiss, Integer> {
    @Query("select r from RegistreNaiss r where r.annee=:d")
    List<RegistreNaiss> findByDate(@Param("d") String date);

    List<RegistreNaiss> findByAnnee(int annee);

    RegistreNaiss findRegistreNaissByAnneeAndPartie(Integer annee,Integer partie);

}

