package com.civil.project.service;

import com.civil.project.dao.JugeNaissanceMargArRep;
import com.civil.project.dao.JugeNaissanceMargFrRep;
import com.civil.project.dao.JugeNaissanceRegistreRep;
import com.civil.project.entity.MargJugeNaissAr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarginaleArJugeNaissanceServiceImpl implements MarginaleArJugeNaissanceService {
    private final JugeNaissanceMargArRep jugeNaissanceMargArRep;

    /////////////////////////////Partie Marginale Arabe de juge de naissance

    //ajouter marginal arabic de juge de naissance
    @Override
    public void AjouterOuModifierMargAr(MargJugeNaissAr margJugeNaissAr) {
        jugeNaissanceMargArRep.save(margJugeNaissAr);
    }

    //afficher les marginales arabic de juge de naissance
    @Override
    public List<MargJugeNaissAr> afficherMarginalAr() {
        return jugeNaissanceMargArRep.findAll();
    }

    //supprimer marginal arabic de juge de naissance
    @Override
    public void SupprimerMargAr(int idMargeJuge) {
        jugeNaissanceMargArRep.deleteById(idMargeJuge);
    }

    //chercher le marginal arabic de juge de naissance a partir de id acte de juge de naissance
    @Override
    public List<MargJugeNaissAr> MargArByIdActeJugeNaissance(int id) {
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
            throw new RuntimeException("Registre non trouve");
        }
        return margJugeNaissAr;
    }
}
