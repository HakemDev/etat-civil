package com.civil.project.deces.dao;

import com.civil.project.deces.entity.ActeDeces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface DecesActeRep extends JpaRepository<ActeDeces,Integer> {
    List<ActeDeces> findActeDecesByRegistreDecesAnnee(int i);
    Set<ActeDeces> findActeDecesByNomAr(String nomAr);
    Set<ActeDeces> findActeDecesByNomFr(String nomFr);

    Collection<Object> findBySexeFr(String homme);
    Collection<Object> findBySexeAr(String femme);
}
