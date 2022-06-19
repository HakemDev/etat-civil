package com.civil.project.security.rest;

import com.civil.project.security.dao.UtilisateurRepository;
import com.civil.project.security.entity.Utilisateur;
import com.civil.project.security.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateur")
@RequiredArgsConstructor
public class UtilisateurRest {

    private final UtilisateurService service;

    private final UtilisateurRepository repo;

    private final PasswordEncoder encoder;

    @GetMapping("/")
    public List<Utilisateur> getutilisateur()
    {
        return service.findUtilisateur();
    }

    @GetMapping("/{id}")
    public Utilisateur findByRole(@PathVariable int id) {
        return service.findById(id);
    }

    @PutMapping("/")
    public Utilisateur update(@RequestBody Utilisateur utilisateur) {
        if(utilisateur.getMotDePasse() == null) {
            utilisateur.setMotDePasse(repo.findById(utilisateur.getId()).get().getMotDePasse());
        } else {
        utilisateur.setMotDePasse(encoder.encode(utilisateur.getMotDePasse()));

        }
        return repo.save(utilisateur);
    }
    @PostMapping("/")
    public Utilisateur add(@RequestBody Utilisateur utilisateur){

        if(repo.findByLogin(utilisateur.getLogin()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Login deja pris");
        }
        utilisateur.setMotDePasse(encoder.encode(utilisateur.getMotDePasse()));
        return repo.save(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        Optional<Utilisateur> user = repo.findById(Integer.parseInt(id));
        if( !user.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Id invalide");
        }
        repo.delete(user.get());
    }
}
