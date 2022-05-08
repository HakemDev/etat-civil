package com.civil.project.dao;

import com.civil.project.entity.ActeJugeNaissancee;
import com.civil.project.entity.ActeNaissance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface JugeNaissanceActeRep extends JpaRepository<ActeJugeNaissancee,Integer> {
    List<ActeJugeNaissancee> findByAnnee(int i);

    List<ActeJugeNaissancee> findByNomAr(String nomAr);

    List<ActeJugeNaissancee> findByNomFr(String nomFr);

    List<ActeJugeNaissancee> findBySexAr(String sexearabe);

    List<ActeJugeNaissancee> findBySexFr(String sexefrancais);

}
