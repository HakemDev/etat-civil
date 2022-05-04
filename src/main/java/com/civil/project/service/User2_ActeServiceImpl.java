package com.civil.project.service;

import com.civil.project.dao.NaissanceActeRep_user2;
import com.civil.project.dao.NaissanceRegistreRep_user3;
import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.RegistreNaiss;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@RequiredArgsConstructor
public class User2_ActeServiceImpl implements User2_ActeService {

    private final NaissanceActeRep_user2 repo;

    private final NaissanceRegistreRep_user3 registreRepo;

    @Override
    public ActeNaissance addActe(ActeNaissance acteNaissance) {
        RegistreNaiss registreNaiss = registreRepo.findRegistreNaissByAnneeAndPartie(
                acteNaissance.getRegistre().getAnnee(),
                acteNaissance.getRegistre().getPartie()
        );


        if(registreNaiss == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Le registre %d/%d n'exsite pas",
                            acteNaissance.getRegistre().getAnnee(),
                            acteNaissance.getRegistre().getPartie()));
        }

        acteNaissance.setRegistre(registreNaiss);
        return repo.save(acteNaissance);
    }

    @Override
    public ActeNaissance updateActe(ActeNaissance acteNaissance) {
        return repo.save(acteNaissance);
    }

    @Override
    public void deleteActe(Integer idActe) {
        repo.deleteById(idActe);
    }

    @Override
    public Collection<ActeNaissance> findActes(String nomAr, String nomFr, String numero) {

        Set<ActeNaissance> byNomAr = null, byNomFr = null;
        List<ActeNaissance> byNumero = null;

        if(nomAr != null) {
            byNomAr = repo.findActeNaissanceByNomAr(nomAr);
        }

        if(nomFr != null) {
            byNomFr = repo.findActeNaissanceByNomFr(nomFr);
        }

        if(numero != null){
            String[] partieAnnee = numero.split("/");
            RegistreNaiss registreNaissByAnneeAndPartie = registreRepo.findRegistreNaissByAnneeAndPartie(
                    Integer.parseInt(partieAnnee[1]),
                    Integer.parseInt(partieAnnee[0])
            );
            byNumero = registreNaissByAnneeAndPartie != null ?
                    registreNaissByAnneeAndPartie.getActes() : new ArrayList<>();
        }

        Set<ActeNaissance> result = new HashSet<>(repo.findAll());

        if(byNomAr != null) result.retainAll(byNomAr);
        if(byNomFr != null) result.retainAll(byNomFr);
        if(byNumero != null) result.retainAll(byNumero);

        return result;
    }
}
