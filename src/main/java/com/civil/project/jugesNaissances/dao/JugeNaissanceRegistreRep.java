package com.civil.project.jugesNaissances.dao;

import com.civil.project.jugesNaissances.entity.RegistreJugeNaiss;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugeNaissanceRegistreRep extends JpaRepository<RegistreJugeNaiss,Integer> {
    List<RegistreJugeNaiss> findByAnnee(int date);

    RegistreJugeNaiss findRegistreNaissByAnneeAndPartie(int parseInt, int parseInt1);
}
