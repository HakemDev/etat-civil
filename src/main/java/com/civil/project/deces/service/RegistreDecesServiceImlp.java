package com.civil.project.deces.service;

import com.civil.project.deces.dao.DecesActeRep;
import com.civil.project.deces.dao.DecesRegistreRep;
import com.civil.project.deces.entity.RegistreDeces;
import com.civil.project.jugesDeces.entity.RegistreJugesDeces;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistreDecesServiceImlp implements RegistreDecesService {

    private final DecesRegistreRep repository;
    private final DecesActeRep decesActeRep;
    @Override
    public RegistreDeces ajouterRegistreD(RegistreDeces registreDeces) {
        RegistreDeces duplicateTest = repository
                .findByAnneeAndPartie(
                        registreDeces.getAnnee(),registreDeces.getPartie()
                );

        if(duplicateTest != null) {
            if(registreDeces.getIdRegistreDeces() == 0 ||
                    (registreDeces.getIdRegistreDeces() != 0 &&
                            registreDeces.getIdRegistreDeces() != duplicateTest.getIdRegistreDeces()))

                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("Le registre %d/%d existe deja",registreDeces.getPartie(),registreDeces.getAnnee()));

        }

        if(registreDeces.getPartie() > 1) {
            RegistreDeces dernier =
                    repository.findByAnneeAndPartie(registreDeces.getAnnee(),registreDeces.getPartie() - 1);

            if(dernier == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("Le registre %d/%d ne peut pas etre cree avant le registre %d/%d",
                                registreDeces.getPartie(),registreDeces.getAnnee(),registreDeces.getPartie()-1,registreDeces.getAnnee()));

            }
        }
        return repository.save(registreDeces);

    }

    @Override
    public RegistreDeces modifierRegistreD(RegistreDeces registreDeces) {
        Optional<RegistreDeces> byId = repository.findById(
                registreDeces.getIdRegistreDeces()
        );
        if(byId.isPresent()){
            return repository.save(registreDeces);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registre deces non trouve");


    }

    @Override
    public RegistreDeces trouverParId(int i) {
        Optional<RegistreDeces> byId =repository.findById(i);
        if(byId.isPresent()){
            return byId.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registre de deces non trouve");
    }

    @Override
    public List<RegistreDeces> listerRegistreD() {
        return repository.findAll();
    }

    @Override
    public void supprimerRegistreD(int i) {
        Optional<RegistreDeces> byId =repository.findById(i);
        if( !byId.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registre de deces non trouve");
        }
        decesActeRep.deleteAll(byId.get().getActesDeces());
        repository.deleteById(i);
    }

    @Override
    public RegistreDeces findRegistreDecesByAnneeAndPartie(int annee, int partie) {

        RegistreDeces result = repository.findByAnneeAndPartie(annee,partie);
        if(result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Le registre %d/%d n'existe pas",partie,annee));
        }
        return result;
    }
}
