package com.civil.project.security.service;

import com.civil.project.security.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    List<Utilisateur> findUtilisateur();
    Utilisateur findById(int id);
    void addOrUpdateUser(Utilisateur utilisateur);
    void deleteUtilisateur(int id);
    Utilisateur findByLogin(String login);

    }
