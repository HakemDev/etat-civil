package com.civil.project.dao;

import com.civil.project.entity.ActeDeces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DecesActeRep extends JpaRepository<ActeDeces,Integer> {
    List<ActeDeces> findActeDecesByRegistreDecesAnnee(int i);
}
