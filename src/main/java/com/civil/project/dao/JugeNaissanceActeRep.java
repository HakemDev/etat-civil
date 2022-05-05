package com.civil.project.dao;

import com.civil.project.entity.ActeJugeNaissancee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface JugeNaissanceActeRep extends JpaRepository<ActeJugeNaissancee,Integer> {
    List<ActeJugeNaissancee> findByAnnee(int i);
}
