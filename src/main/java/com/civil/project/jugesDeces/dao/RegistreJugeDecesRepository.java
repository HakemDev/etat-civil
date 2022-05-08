package com.civil.project.jugesDeces.dao;

import com.civil.project.jugesDeces.entity.RegistreJugesDeces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistreJugeDecesRepository extends JpaRepository<RegistreJugesDeces,Integer> {

    RegistreJugesDeces findRegistreJugesDecesByAnneeAndPartie(Integer annee,Integer partie);

    List<RegistreJugesDeces> findRegistreJugesDecesByAnnee(Integer annne);

}
