package com.civil.project.service;

import com.civil.project.dao.JugeNaissanceActeRep;
import com.civil.project.dao.JugeNaissanceMargArRep;
import com.civil.project.entity.ActeJugeNaissancee;
import com.civil.project.entity.MargJugeNaissAr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
    public class ActeJugeNaissanceServiceImpl implements ActeJugeNaissanceService{
    private final JugeNaissanceActeRep jugeNaissanceActeRep;

    @Override
    public void AjouterOuModifierActeJugNaissa(ActeJugeNaissancee acteJugeNaissance) {
        jugeNaissanceActeRep.save(acteJugeNaissance);
    }

    @Override
    public List<ActeJugeNaissancee> afficherActeJugeNaiss() {
        return jugeNaissanceActeRep.findAll();
    }

    @Override
    public void SupprimerActeJugeNaiss(int idActeJugeNais) {
        jugeNaissanceActeRep.deleteById(idActeJugeNais);
    }

    @Override
    public ActeJugeNaissancee ActeJugeNaiss(int id) {

        Optional<ActeJugeNaissancee> resultat=jugeNaissanceActeRep.findById(id);

        ActeJugeNaissancee acteJugeNaissancee=null;
        if(resultat.isPresent())
        {
            acteJugeNaissancee=resultat.get();
        }
        else {
            throw new RuntimeException("Registre non trouve");
        }
        return acteJugeNaissancee;
    }
}
