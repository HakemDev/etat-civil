package com.civil.project.service;

import com.civil.project.dao.UtilisateurRepository;
import com.civil.project.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired
    private UtilisateurRepository utlRep;

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
