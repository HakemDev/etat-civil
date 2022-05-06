package com.civil.project.service;

import com.civil.project.dao.UtilisateurRep_user3;
import com.civil.project.entity.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

    private UtilisateurRep_user3 utlRep;

    ///chercher tous les utilisateur
    @Override
    public List<Utilisateur> findUtilisateur() {
        System.out.println(utlRep.findAll().get(0).getRegistresjugenaissa());
        return utlRep.findAll();
    }

    ///chercher les utilisateur selon leur role
    @Override
    public List<Utilisateur> findByRole(String role) {

        return utlRep.findByRole(role);
    }
    ///ajouter ou supprimer un utilisateur
    @Override
    public void addOrUpdateUser(Utilisateur utilisateur) {
        utlRep.save(utilisateur);
    }
    ///supprimer un utilisateur
    @Override
    public void deleteUtilisateur(int id) {
        utlRep.deleteById(id);
    }
}
