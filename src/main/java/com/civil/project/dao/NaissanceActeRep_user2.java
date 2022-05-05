package com.civil.project.dao;

import com.civil.project.entity.ActeNaissance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface NaissanceActeRep_user2 extends JpaRepository<ActeNaissance, Integer> {
    List<ActeNaissance> findByAnnee(int annee);
    Set<ActeNaissance> findActeNaissanceByNomAr(String nomAr);

    Set<ActeNaissance> findActeNaissanceByNomFr(String nomAr);
}
