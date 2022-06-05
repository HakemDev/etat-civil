package com.civil.project.naissances.service;

import com.civil.project.naissances.dao.NaissanceActeRepository;
import com.civil.project.naissances.dao.RegistreNaissanceRepository;
import com.civil.project.naissances.entity.RegistreNaiss;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class RegistreNaissServiceImpl implements RegistreNaissService {

    private final RegistreNaissanceRepository registreRepository;
    private final NaissanceActeRepository acteRep;

    @Override
    public List<RegistreNaiss> findByDate(String date) {
        return registreRepository.findByDate(date);
    }

    @Override
    public List<RegistreNaiss> findByAnnee(int annee) {
        return registreRepository.findByAnnee(annee);
    }


    public RegistreNaiss findRegistreNaissByAnneeAndPartie(Integer annee,Integer partie){
        RegistreNaiss registreNaissByAnneeAndPartie = registreRepository.findRegistreNaissByAnneeAndPartie(annee, partie);

        if(registreNaissByAnneeAndPartie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Le registre %d/%d n'existe pas",partie,annee));

        }
        return registreNaissByAnneeAndPartie;
    }


    @Override
    public List<RegistreNaiss> findRegistres() {
        return registreRepository.findAll();
    }

    @Override
    public RegistreNaiss findByIdRegistre(int idRegistre) {
        Optional<RegistreNaiss> resultat=registreRepository.findById(idRegistre);
        if( !resultat.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registre non trouve");

        return resultat.get();
    }

    @Override
    public void deleteRegistre(int id) {
        Optional<RegistreNaiss> resultat=registreRepository.findById(id);
        if( !resultat.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registre non trouve");
        registreRepository.delete(resultat.get());
    }

    @Override
    public RegistreNaiss updateRegistre(RegistreNaiss registre) {
        Optional<RegistreNaiss> resultat=registreRepository.findById(registre.getIdRegistre());
        if( !resultat.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registre non trouve");
        return addRegistre(registre);
    }

    public RegistreNaiss addRegistre(RegistreNaiss registre) {

        RegistreNaiss duplicateTest = registreRepository
                .findRegistreNaissByAnneeAndPartie(registre.getAnnee(), registre.getPartie());

        if(duplicateTest != null) {
            if(registre.getIdRegistre() == 0 ||
            // if inserting new registre no matches should be found
            (registre.getIdRegistre() != 0  &&
                    registre.getIdRegistre() != duplicateTest.getIdRegistre() ))
            // if updating, a match should be found, and it should have the same id
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Le registre %d/%d existe deja",registre.getPartie(),registre.getAnnee()));
        }

        if(registre.getPartie() > 1){
            RegistreNaiss dernier =
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
