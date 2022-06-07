package com.civil.project.naissances.service;

import com.civil.project.naissances.dao.MargNaissArRepository;
import com.civil.project.naissances.dao.MargNaissFrRepository;
import com.civil.project.naissances.dao.NaissanceActeRepository;
import com.civil.project.naissances.dao.RegistreNaissanceRepository;
import com.civil.project.naissances.entity.ActeNaissance;
import com.civil.project.naissances.entity.RegistreNaiss;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ActeServiceImpl implements ActeService {

    private final NaissanceActeRepository repo;

    private final RegistreNaissanceRepository registreRepo;

    private final MargNaissArRepository margNaissArRepository;

    private final MargNaissFrRepository margNaissFrRepository;

    @Override
    public ActeNaissance addActe(ActeNaissance acteNaissance) {
        RegistreNaiss registreNaiss = registreRepo.findRegistreNaissByAnneeAndPartie(
                acteNaissance.getRegistre().getAnnee(),
                acteNaissance.getRegistre().getPartie()
        );


        if(registreNaiss == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Le registre %d/%d n'exsite pas",
                            acteNaissance.getRegistre().getAnnee(),
                            acteNaissance.getRegistre().getPartie()));
        }


        for(ActeNaissance acte : registreNaiss.getActes()) {
                if(acteNaissance.getNumeroActe() == acte.getNumeroActe()
                    && acteNaissance.getIdNaissance() != acte.getIdNaissance()
                ){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            String.format("L'acte numero %d dans le registre %d/%d existe deja",
                                    acteNaissance.getNumeroActe(),
                                    acteNaissance.getRegistre().getAnnee(),
                                    acteNaissance.getRegistre().getPartie()));

            }
        }


        registreNaiss.setNombreActes(registreNaiss.getNombreActes() + 1);
        registreNaiss.setDernierNumero(acteNaissance.getNumeroActe());
        if(acteNaissance.getRegistre().getIdRegistre() == 0)
            acteNaissance.setRegistre(registreNaiss);
        return repo.save(acteNaissance);
    }

    @Override
    public ActeNaissance updateActe(ActeNaissance acteNaissance) {

        if(acteNaissance == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Acte invalide");
        }

        if( !repo.findById(acteNaissance.getIdNaissance()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte non existant");
        }

        return addActe(acteNaissance);
    }

    @Override
    public void deleteActe(Integer idActe) {
        margNaissArRepository.deleteAll(margNaissArRepository.findByActeNaissanceIdNaissance(idActe));
        margNaissFrRepository.deleteAll(margNaissFrRepository.findByActeNaissanceIdNaissance(idActe));
        repo.deleteById(idActe);
    }

    @Override
    public ActeNaissance findActeById(Integer idActe) {
        Optional<ActeNaissance> acteNaissance = repo.findById(idActe);
        if(!acteNaissance.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte non trouve");
          return acteNaissance.get();
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
            if(!numero.matches("[0-9]+/[0-9]{4}")){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Numero de registre invalide");
            }
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
