package com.civil.project.dao;

import com.civil.project.entity.RegistreDeces;
import com.civil.project.entity.RegistreJugeNaiss;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DecesRegistreRep extends JpaRepository<RegistreDeces,Integer> {
    List<RegistreDeces> findByAnnee(int date);
}
