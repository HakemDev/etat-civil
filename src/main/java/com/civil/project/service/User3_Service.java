package com.civil.project.service;

import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.RegistreNaiss;
import com.civil.project.entity.Utilisateur;

import java.util.List;

public interface User3_Service {

    public List<RegistreNaiss> findByDate(String date);
    public List<RegistreNaiss> findRegistres();

    public ActeNaissance findById(int idActe);

    public RegistreNaiss findByIdActe(int idActe);

    public void deleteActe(int id);

    public void addOrUpdateRegistre(RegistreNaiss registre);

    List<Utilisateur> findUtilisateur();

    List<Utilisateur> findByRole(String role);

    void addOrUpdateUser(Utilisateur utilisateur);

    void deleteUtilisateur(int id);
}
