package com.civil.project.jugesDeces.dao;


import com.civil.project.jugesDeces.entity.JugeDeces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface JugeDecesRepository extends JpaRepository<JugeDeces,Integer> {
    List<JugeDeces> findJugeDecesByRegistreJugesDecesAnnee(int annee);

    Set<JugeDeces> findJugeDecesByNomAr(String nomAr);

    Set<JugeDeces> findJugeDecesByNomFr(String nomAr);

    List<JugeDeces> findBySexeFr(String homme);

    List<JugeDeces> findBySexeAr(String femme);
}
