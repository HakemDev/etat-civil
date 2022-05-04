package com.civil.project.dao;

import com.civil.project.entity.RegistreJugeNaiss;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugeNaissanceRegistreRep extends JpaRepository<RegistreJugeNaiss,Integer> {
    List<RegistreJugeNaiss> findByAnnee(int date);
}
