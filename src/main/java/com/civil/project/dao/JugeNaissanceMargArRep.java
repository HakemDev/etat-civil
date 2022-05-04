package com.civil.project.dao;

import com.civil.project.entity.MargJugeNaissAr;
import com.civil.project.entity.MargJugeNaissFr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugeNaissanceMargArRep extends JpaRepository<MargJugeNaissAr,Integer> {
    List<MargJugeNaissAr> findByIdActeJugeNais(int id);
}
