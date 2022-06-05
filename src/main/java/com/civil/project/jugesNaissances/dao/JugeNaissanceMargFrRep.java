package com.civil.project.jugesNaissances.dao;

import com.civil.project.jugesNaissances.entity.MargJugeNaissFr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugeNaissanceMargFrRep extends JpaRepository<MargJugeNaissFr,Integer> {
    List<MargJugeNaissFr> findByIdActeJugeNais(int id);
}
