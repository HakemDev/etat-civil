package com.civil.project.jugesNaissances.dao;

import com.civil.project.jugesNaissances.entity.ActeJugeNaissancee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugeNaissanceActeRep extends JpaRepository<ActeJugeNaissancee,Integer> {
    List<ActeJugeNaissancee> findByAnnee(int i);

    List<ActeJugeNaissancee> findByNomAr(String nomAr);

    List<ActeJugeNaissancee> findByNomFr(String nomFr);

    List<ActeJugeNaissancee> findBySexAr(String sexearabe);

    List<ActeJugeNaissancee> findBySexFr(String sexefrancais);

}
