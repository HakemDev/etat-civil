package com.civil.project.service;

import com.civil.project.dao.JugeNaissanceMargFrRep;
import com.civil.project.entity.MargJugeNaissFr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarginaleFrJugeNaissanceServiceImpl implements MargianleFrJugeNaissanceService {

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
        jugeNaissanceMargFrRep.deleteById(idMarginal);
    }

    //chercher le marginal francais de juge de naissance a partir de ID acte de juge de naissance
    @Override
    public List<MargJugeNaissFr> MargFrByIdActeJugeNaissance(int idActeJugeNaissa) {

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
            throw new RuntimeException("Registre non trouve");
        }
        return margJugeNaissFr;
    }
}
