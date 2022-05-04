package com.civil.project.service;

import com.civil.project.dao.NaissanceActeRep_user2;
import com.civil.project.dao.NaissanceRegistreRep_user3;
import com.civil.project.dao.UtilisateurRep_user3;
import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.RegistreNaiss;
import com.civil.project.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class User3_ServiceImpl implements User3_Service{
    private NaissanceRegistreRep_user3 registreRepository;
    private NaissanceActeRep_user2 acteRep;
    private UtilisateurRep_user3 utlRep;
    @Autowired

    public User3_ServiceImpl(NaissanceRegistreRep_user3 registreRepository,NaissanceActeRep_user2 acte,UtilisateurRep_user3 utlRep) {
        this.registreRepository = registreRepository;
        this.acteRep = acte;
        this.utlRep=utlRep;
    }

    @Override
    public ActeNaissance findById(int idActe) {
        Optional<ActeNaissance> resultat=acteRep.findById(idActe);
        ActeNaissance acte=null;
        if(resultat.isPresent())
        {
            acte=resultat.get();
            // System.out.println(acte.getRegistre());
        }
        else
        {
            throw new RuntimeException("acte non trouve ");
        }
        return acte;
    }
    /////// Partie registre
    //chercher registre de naissance par leur date de creation
    @Override
    public List<RegistreNaiss> findByDate(String date) {
        return registreRepository.findByDate(date);
    }
    //chercher tous les registres de naissance
    @Override
    public List<RegistreNaiss> findRegistres() {
        System.out.println("heyyyy+ "+registreRepository.findAll());
        return registreRepository.findAll();
    }
    //chercher le registre de naissance a partir de son id
    @Override
    public RegistreNaiss findByIdRegistre(int idRegistre) {
        Optional<RegistreNaiss> resultat=registreRepository.findById(idRegistre);

        RegistreNaiss Registres=null;
        if(resultat.isPresent())
        {
            //acte=resultat.get();
            Registres=resultat.get();
        }
        else {
            throw new RuntimeException("Registre non trouve");
        }
        return Registres;
    }
    // supprimer le registre de naissance a partir de son id
    @Override
    public void deleteRegistre(int id) {
        registreRepository.deleteById(id);
    }
    /// ajouter ou modifier un registre de naissance
    @Override
    public void addOrUpdateRegistre(RegistreNaiss registre) {
        registreRepository.save(registre);
    }


    ////////////////// Partie d'utilisateur

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
