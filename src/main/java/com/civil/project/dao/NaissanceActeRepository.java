package com.civil.project.dao;

import com.civil.project.entity.ActeNaissance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Set;

@Repository
public interface NaissanceActeRepository extends JpaRepository<ActeNaissance, Integer> {
    List<ActeNaissance> findByAnnee(int annee);

    Set<ActeNaissance> findActeNaissanceByNomAr(String nomAr);

    Set<ActeNaissance> findActeNaissanceByNomFr(String nomAr);

    List<ActeNaissance> findBySexAr(String sexearabe);

    List<ActeNaissance> findBySexFr(String sexefrancai);
}
