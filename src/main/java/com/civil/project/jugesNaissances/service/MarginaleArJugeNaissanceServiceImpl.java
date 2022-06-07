package com.civil.project.jugesNaissances.service;

import com.civil.project.jugesNaissances.dao.JugeNaissanceActeRep;
import com.civil.project.jugesNaissances.dao.JugeNaissanceMargArRep;
import com.civil.project.jugesNaissances.entity.ActeJugeNaissancee;
import com.civil.project.jugesNaissances.entity.MargJugeNaissAr;
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
    private final JugeNaissanceActeRep jugeNaissanceRep;

    /////////////////////////////Partie Marginale Arabe de juge de naissance

    //ajouter marginal arabic de juge de naissance
    @Override
    public MargJugeNaissAr AjouterOuModifierMargAr(MargJugeNaissAr margJugeNaissFr) {
        Optional<ActeJugeNaissancee> juge = jugeNaissanceRep.findById
                (margJugeNaissFr.getActeNaissance().getIdNaissance());

        if( !juge.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte introuvable");
        }

        margJugeNaissFr.setActeNaissance(juge.get());

        return jugeNaissanceMargArRep.save(margJugeNaissFr);
    }

    @Override
    public MargJugeNaissAr updateMarg(MargJugeNaissAr margJugeNaissAr) {
        Optional<MargJugeNaissAr> byId = jugeNaissanceMargArRep.findById(margJugeNaissAr.getIdMarginalAr());
        if(!byId.isPresent())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Marginale non trouvee");

        if(margJugeNaissAr.getMarginaleTxtAr().trim().isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Le texte ne peut pas etre vide");
        }
        MargJugeNaissAr toUpdate = byId.get();
        toUpdate.setMarginaleTxtAr(margJugeNaissAr.getMarginaleTxtAr());
        return jugeNaissanceMargArRep.save(toUpdate);
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
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("il n'y a aucune marginale de juge de naissance avec l'id %d  ",idMargeJuge));

    }

    //chercher le marginal arabic de juge de naissance a partir de id acte de juge de naissance
    @Override
    public List<MargJugeNaissAr> MargArByIdActeJugeNaissance(int id) {
        if(jugeNaissanceMargArRep.findByActeNaissanceIdNaissance(id).isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("il n'y a aucun marginal lie avec l'id %d d'acte de juge de naissance ",id));
        }
        return jugeNaissanceMargArRep.findByActeNaissanceIdNaissance(id);
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
