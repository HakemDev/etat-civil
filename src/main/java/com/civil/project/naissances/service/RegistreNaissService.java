package com.civil.project.naissances.service;

import com.civil.project.naissances.entity.RegistreNaiss;

import java.util.List;

public interface RegistreNaissService {

    List<RegistreNaiss> findByDate(String date);

    List<RegistreNaiss> findRegistres();

    RegistreNaiss findByIdRegistre(int idRegistre);

    void deleteRegistre(int id);

    RegistreNaiss addRegistre(RegistreNaiss registre);

    RegistreNaiss updateRegistre(RegistreNaiss registre);

    List<RegistreNaiss> findByAnnee(int annee);

    RegistreNaiss findRegistreNaissByAnneeAndPartie(Integer annee,Integer partie);

}
