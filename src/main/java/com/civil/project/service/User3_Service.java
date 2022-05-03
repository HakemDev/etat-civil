package com.civil.project.service;

import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.RegistreNaiss;
import com.civil.project.entity.Utilisateur;

import java.util.List;

public interface User3_Service {
    public ActeNaissance findById(int idActe);

    ///partie registre de naissance
    public List<RegistreNaiss> findByDate(String date);
    public List<RegistreNaiss> findRegistres();
    public RegistreNaiss findByIdRegistre(int idRegistre);
    public void deleteRegistre(int id);
    public void addOrUpdateRegistre(RegistreNaiss registre);

    ///Partie utilisateur
    List<Utilisateur> findUtilisateur();
    List<Utilisateur> findByRole(String role);
    void addOrUpdateUser(Utilisateur utilisateur);
    void deleteUtilisateur(int id);
}
