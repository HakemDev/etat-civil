package com.civil.project.service;

import com.civil.project.dao.JugeNaissanceMargArRep;
import com.civil.project.dao.JugeNaissanceMargFrRep;
import com.civil.project.dao.JugeNaissanceRegistreRep;
import com.civil.project.entity.RegistreJugeNaiss;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistreJugeNaissanceServiceImpl implements RegistreJugeNaissanceService{
    private final JugeNaissanceRegistreRep jugeNaissanceRegistreRep;

/////////////////////partie registre de jug de naissance

    // afficher tous les registre de juge de naissance
    @Override
    public List<RegistreJugeNaiss> findRegistres() {
        return jugeNaissanceRegistreRep.findAll();
    }
    //rechercher le registre de juge de naissance a partir de l'année
    @Override
    public List<RegistreJugeNaiss> findByDate(int date) {
        return jugeNaissanceRegistreRep.findByAnnee(date);
    }
    //afficher le registre de juge de naissance a partir de ID de registre
    @Override
    public RegistreJugeNaiss findByIdRegistre(int idRegistre) {
        Optional<RegistreJugeNaiss> resultat=jugeNaissanceRegistreRep.findById(idRegistre);

        RegistreJugeNaiss Registres=null;
        if(resultat.isPresent())
        {
            //acte=resultat.get();
            Registres=resultat.get();
        }
        else {
            throw new RuntimeException("Registre non trouve");
        }
        return Registres;
    }
    //supprimrer le registre de juge de naissance a partir de ID du Registre
    @Override
    public void deleteActe(int id) {
        jugeNaissanceRegistreRep.deleteById(id);
    }
    //ajouter ou modifier un registre de juge de naissance
    @Override
    public void addOrUpdateRegistre(RegistreJugeNaiss registre) {
        jugeNaissanceRegistreRep.save(registre);
    }
}
