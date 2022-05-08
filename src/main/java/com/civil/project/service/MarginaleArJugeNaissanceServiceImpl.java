package com.civil.project.service;

import com.civil.project.dao.JugeNaissanceMargArRep;
import com.civil.project.entity.MargJugeNaissAr;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarginaleArJugeNaissanceServiceImpl implements MarginaleArJugeNaissanceService {
    private final JugeNaissanceMargArRep jugeNaissanceMargArRep;

    /////////////////////////////Partie Marginale Arabe de juge de naissance

    //ajouter marginal arabic de juge de naissance
    @Override
    public MargJugeNaissAr AjouterOuModifierMargAr(MargJugeNaissAr margJugeNaissAr) {
        jugeNaissanceMargArRep.save(margJugeNaissAr);
        return margJugeNaissAr;
    }

    //afficher les marginales arabic de juge de naissance
    @Override
    public List<MargJugeNaissAr> afficherMarginalAr() {
        return jugeNaissanceMargArRep.findAll();
    }

    //supprimer marginal arabic de juge de naissance
    @Override
    public void SupprimerMargAr(int idMargeJuge) {
        if(MargArById(idMargeJuge)!=null) {
            jugeNaissanceMargArRep.deleteById(idMargeJuge);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("il n'y a aucun marginal de juge de naissance avec l'id %d  ",idMargeJuge));

    }

    //chercher le marginal arabic de juge de naissance a partir de id acte de juge de naissance
    @Override
    public List<MargJugeNaissAr> MargArByIdActeJugeNaissance(int id) {
        if(jugeNaissanceMargArRep.findByIdActeJugeNais(id).isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("il n'y a aucun marginal lie avec l'id %d d'acte de juge de naissance ",id));
        }
        return jugeNaissanceMargArRep.findByIdActeJugeNais(id);
    }

    //chercher le marginal francais de juge de naissance a partir de id du marginale de juge de naissance
    @Override
    public MargJugeNaissAr MargArById(int id) {
        Optional<MargJugeNaissAr> resultat=jugeNaissanceMargArRep.findById(id);

        MargJugeNaissAr margJugeNaissAr=null;
        if(resultat.isPresent())
        {
            //acte=resultat.get();
            margJugeNaissAr=resultat.get();
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Marginale de juge de naissance arabe introuvable");
        }
        return margJugeNaissAr;
    }
}
