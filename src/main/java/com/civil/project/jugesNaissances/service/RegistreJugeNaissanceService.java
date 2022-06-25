package com.civil.project.jugesNaissances.service;

import com.civil.project.jugesNaissances.dao.JugeNaissanceActeRep;
import com.civil.project.jugesNaissances.dao.JugeNaissanceRegistreRep;
import com.civil.project.jugesNaissances.entity.RegistreJugeNaiss;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class RegistreJugeNaissanceService {

    private final JugeNaissanceRegistreRep registreRepository;
    private final JugeNaissanceActeRep acteRep;

    public List<RegistreJugeNaiss> findByAnnee(int annee){
        return registreRepository.findByAnnee(annee);
    }

    public RegistreJugeNaiss findByAnneeAndPartie(Integer annee,Integer partie){
        RegistreJugeNaiss registreNaissByAnneeAndPartie = registreRepository.findRegistreNaissByAnneeAndPartie(annee, partie);

        if(registreNaissByAnneeAndPartie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Le registre %d/%d n'existe pas",partie,annee));

        }
        return registreNaissByAnneeAndPartie;
    }

    public List<RegistreJugeNaiss> findAll() {
        return registreRepository.findAll();
    }

    public RegistreJugeNaiss findByIdJuge(int id) {
        Optional<RegistreJugeNaiss> res = registreRepository.findById(id);
        if( !res.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registre non trouve");
        return res.get();
    }

    public void deleteRegistre(int id) {
        Optional<RegistreJugeNaiss> resultat=registreRepository.findById(id);
        if( !resultat.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registre non trouve");
        acteRep.deleteAll(resultat.get().getActesjugenaissancee());
        registreRepository.delete(resultat.get());
    }

    public RegistreJugeNaiss updateRegistre(RegistreJugeNaiss registre) {
        Optional<RegistreJugeNaiss> resultat=registreRepository.findById(registre.getIdRegistre());
        if( !resultat.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registre non trouve");
        return registreRepository.save(registre);
    }

    public RegistreJugeNaiss addRegistre(RegistreJugeNaiss registre) {

        RegistreJugeNaiss duplicateTest = registreRepository
                .findRegistreNaissByAnneeAndPartie(registre.getAnnee(), registre.getPartie());

        if(duplicateTest != null) {
            if(registre.getIdRegistre() == 0 ||

                    (registre.getIdRegistre() != 0  &&
                            registre.getIdRegistre() != duplicateTest.getIdRegistre() ))

                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("Le registre %d/%d existe deja",registre.getPartie(),registre.getAnnee()));
        }

        if(registre.getPartie() > 1){
            RegistreJugeNaiss dernier =
                    registreRepository.
                            findRegistreNaissByAnneeAndPartie(registre.getAnnee(),registre.getPartie() - 1);
            if(dernier == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("Le registre %d/%d ne peut pas etre cree avant le registre %d/%d",
                                registre.getPartie(),registre.getAnnee(),registre.getPartie()-1,registre.getAnnee()));

            }
        }
        return registreRepository.save(registre);
    }
}
