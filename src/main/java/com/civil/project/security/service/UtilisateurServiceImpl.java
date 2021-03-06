package com.civil.project.security.service;

import com.civil.project.security.dao.UtilisateurRepository;
import com.civil.project.security.entity.Utilisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService{

    private final UtilisateurRepository utlRep;

    ///chercher tous les utilisateur
    @Override
    public List<Utilisateur> findUtilisateur() {
        return utlRep.findAll();
    }

    @Override
    public Utilisateur findByLogin(String login) {
        Optional<Utilisateur> user = utlRep.findByLogin(login);
        return user.orElse(null);
    }


    ///chercher les utilisateur selon leur role
    @Override
    public Utilisateur findById(int id) {

        Optional<Utilisateur> byId = utlRep.findById(id);
        if (byId.isPresent())
            return byId.get();

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Utilisateur non trouve");
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
