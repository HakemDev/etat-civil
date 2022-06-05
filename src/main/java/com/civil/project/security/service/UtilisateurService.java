package com.civil.project.security.service;

import com.civil.project.security.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    List<Utilisateur> findUtilisateur();
    List<Utilisateur> findByRole(String role);
    void addOrUpdateUser(Utilisateur utilisateur);
    void deleteUtilisateur(int id);
}
