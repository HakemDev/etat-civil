package com.civil.project.service;

import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.RegistreNaiss;

import java.util.List;

public interface RegistreNaissService {

    List<RegistreNaiss> findByDate(String date);

    List<RegistreNaiss> findRegistres();

    RegistreNaiss findByIdRegistre(int idRegistre);

    void deleteRegistre(int id);

    RegistreNaiss addRegistre(RegistreNaiss registre);

    List<RegistreNaiss> findByAnnee(int annee);

    RegistreNaiss findRegistreNaissByAnneeAndPartie(Integer annee,Integer partie);

    ActeNaissance findById(int idActe);
}
