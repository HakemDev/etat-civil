package com.civil.project.jugesNaissances.dao;

import com.civil.project.jugesNaissances.entity.MargJugeNaissAr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugeNaissanceMargArRep extends JpaRepository<MargJugeNaissAr,Integer> {
    List<MargJugeNaissAr> findByActeNaissanceIdNaissance(int id);
}
