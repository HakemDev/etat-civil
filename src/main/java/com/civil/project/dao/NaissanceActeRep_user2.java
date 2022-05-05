package com.civil.project.dao;

import com.civil.project.entity.ActeNaissance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface NaissanceActeRep_user2 extends JpaRepository<ActeNaissance, Integer> {
    List<ActeNaissance> findByAnnee(int annee);

    Set<ActeNaissance> findActeNaissanceByNomAr(String nomAr);

    Set<ActeNaissance> findActeNaissanceByNomFr(String nomAr);

}
