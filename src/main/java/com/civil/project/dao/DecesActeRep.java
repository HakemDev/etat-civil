package com.civil.project.dao;

import com.civil.project.entity.ActeDeces;
import com.civil.project.entity.ActeJugeNaissancee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DecesActeRep extends JpaRepository<ActeDeces,Integer> {
    List<ActeDeces> findByAnnee(int i);
}
