package com.civil.project.service;

import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.RegistreNaiss;

import java.util.List;

public interface RegistreNaissService {
    public ActeNaissance findById(int idActe);

    public List<RegistreNaiss> findByDate(String date);

    public List<RegistreNaiss> findRegistres();

    public RegistreNaiss findByIdRegistre(int idRegistre);

    public void deleteRegistre(int id);

    public RegistreNaiss addRegistre(RegistreNaiss registre);

    List<RegistreNaiss> findByAnnee(int annee);

    RegistreNaiss findRegistreNaissByAnneeAndPartie(Integer annee,Integer partie);
}
