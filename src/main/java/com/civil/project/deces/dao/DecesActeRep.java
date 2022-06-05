package com.civil.project.deces.dao;

import com.civil.project.deces.entity.ActeDeces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DecesActeRep extends JpaRepository<ActeDeces,Integer> {
    List<ActeDeces> findActeDecesByRegistreDecesAnnee(int i);
}
