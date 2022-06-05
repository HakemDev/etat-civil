package com.civil.project.jugesNaissances.service;

import com.civil.project.jugesNaissances.dao.JugeNaissanceMargFrRep;
import com.civil.project.jugesNaissances.entity.MargJugeNaissFr;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarginaleFrJugeNaissanceServiceImpl implements MarginaleFrJugeNaissanceService {

    private final JugeNaissanceMargFrRep jugeNaissanceMargFrRep;

/////////////////////////////Partie Marginale francais de juge de naissance

    //ajouter marginal francais de juge de naissance
    @Override
    public void AjouterOuModifierMargFR(MargJugeNaissFr margJugeNaissFr) {
        jugeNaissanceMargFrRep.save(margJugeNaissFr);
    }

    //afficher les marginales francais de juge de naissance
    @Override
    public List<MargJugeNaissFr> afficherMarginalFr() {
        return jugeNaissanceMargFrRep.findAll();
    }

    //supprimer marginal francais de juge de naissance
    @Override
    public void SupprimerMargFR(int idMarginal) {
        if(MargFrById(idMarginal)!=null){
            jugeNaissanceMargFrRep.deleteById(idMarginal);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("il n'y a aucun marginal de juge de naissance avec l'id %d  ",idMarginal));
    }

    //chercher le marginal francais de juge de naissance a partir de ID acte de juge de naissance
    @Override
    public List<MargJugeNaissFr> MargFrByIdActeJugeNaissance(int idActeJugeNaissa) {
        if(jugeNaissanceMargFrRep.findByIdActeJugeNais(idActeJugeNaissa).isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("il n'y a aucun marginal lie avec l'id %d d'acte de juge de naissance ",idActeJugeNaissa));
        }
        return jugeNaissanceMargFrRep.findByIdActeJugeNais(idActeJugeNaissa);
    }

    //chercher le marginal francais de juge de naissance a partir de id du marginale de juge de naissance
    @Override
    public MargJugeNaissFr MargFrById(int id) {
        Optional<MargJugeNaissFr> resultat=jugeNaissanceMargFrRep.findById(id);

        MargJugeNaissFr margJugeNaissFr=null;
        if(resultat.isPresent())
        {
            //acte=resultat.get();
            margJugeNaissFr=resultat.get();
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("il n'y a aucun marginal  avec l'id %d  ",id));
        }
        return margJugeNaissFr;
    }
}
