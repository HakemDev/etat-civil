package com.civil.project.rest;

import com.civil.project.entity.Utilisateur;
import com.civil.project.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtilisateurRest {

    @Autowired
    UtilisateurService service;

    @GetMapping("/utilisateurs")
    public List<Utilisateur> getutilisateur()
    {
        return service.findUtilisateur();
    }

    @GetMapping("/utilisateur/{role}")
    public List<Utilisateur> findByRole(@PathVariable String role)
    {
        return service.findByRole(role);
    }

    @PutMapping("/utilisateur/update")
    public Utilisateur update(@RequestBody Utilisateur utilisateur)
    {
        service.addOrUpdateUser(utilisateur);
        return utilisateur;
    }
    @PostMapping("/utilisateur/add")
    public Utilisateur add(@RequestBody Utilisateur utilisateur)
    {
        service.addOrUpdateUser(utilisateur);
        return utilisateur;
    }
    @DeleteMapping("/utilisateur/delete/{id}")
    public String delete(@PathVariable int id)
    {
        service.deleteUtilisateur(id);
        return "delete with succes";
    }
}
