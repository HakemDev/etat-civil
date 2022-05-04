package com.civil.project.dao;

import com.civil.project.entity.MargJugeNaissFr;
import com.civil.project.entity.Marg_nais_fr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugeNaissanceMargFrRep extends JpaRepository<MargJugeNaissFr,Integer> {
    List<MargJugeNaissFr> findByIdActeJugeNais(int id);
}
