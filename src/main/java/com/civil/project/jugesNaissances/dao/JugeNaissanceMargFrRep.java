package com.civil.project.jugesNaissances.dao;

import com.civil.project.jugesNaissances.entity.MargJugeNaissFr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugeNaissanceMargFrRep extends JpaRepository<MargJugeNaissFr,Integer> {
    List<MargJugeNaissFr> findByActeNaissanceIdNaissance(int id);
}
