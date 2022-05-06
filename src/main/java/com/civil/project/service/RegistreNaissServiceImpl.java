package com.civil.project.service;

import com.civil.project.dao.NaissanceActeRepository;
import com.civil.project.dao.NaissanceRegistreRep_user3;
import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.RegistreNaiss;
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

    private final NaissanceRegistreRep_user3 registreRepository;
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
        registreRepository.deleteById(id);
    }

    public RegistreNaiss addRegistre(RegistreNaiss registre) {

        if(registreRepository
            .findRegistreNaissByAnneeAndPartie(registre.getAnnee(),registre.getPartie()) != null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Le registre %d/%d existe deja",registre.getPartie(),registre.getAnnee()));

        if(registre.getPartie() > 1){
            RegistreNaiss dernier =
                    registreRepository.
                    findRegistreNaissByAnneeAndPartie(registre.getAnnee(),registre.getPartie() - 1);
            if(dernier == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Le registre %d/%d ne peut pas etre cree avant le registre %d/%d",
                                registre.getPartie(),registre.getAnnee(),registre.getPartie()-1,registre.getAnnee()));

            }
        }
        return registreRepository.save(registre);
    }

}
