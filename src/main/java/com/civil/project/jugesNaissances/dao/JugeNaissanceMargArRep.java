package com.civil.project.jugesNaissances.dao;

import com.civil.project.jugesNaissances.entity.MargJugeNaissAr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugeNaissanceMargArRep extends JpaRepository<MargJugeNaissAr,Integer> {
    List<MargJugeNaissAr> findByIdActeJugeNais(int id);
}
