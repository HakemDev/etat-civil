package com.civil.project.deces.dao;

import com.civil.project.deces.entity.RegistreDeces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DecesRegistreRep extends JpaRepository<RegistreDeces,Integer> {
    List<RegistreDeces> findByAnnee(int date);
}
