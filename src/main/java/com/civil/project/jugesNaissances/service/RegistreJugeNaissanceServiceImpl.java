package com.civil.project.jugesNaissances.service;

import com.civil.project.jugesNaissances.dao.JugeNaissanceRegistreRep;
import com.civil.project.jugesNaissances.entity.RegistreJugeNaiss;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        List<RegistreJugeNaiss>  registreJugeNaisses=jugeNaissanceRegistreRep.findByAnnee(date);
        if(registreJugeNaisses.isEmpty())
            {

            }
        return registreJugeNaisses;
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Le registre de juge de naissance avec id %d",idRegistre));
        }
        return Registres;
    }
    //supprimrer le registre de juge de naissance a partir de ID du Registre
    @Override
    public void deleteActe(int id) {
        if(jugeNaissanceRegistreRep.findById(id).isPresent()){
            jugeNaissanceRegistreRep.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Le registre de juge de naissance avec id %d n'existe pas",id));
        }
    }
    //ajouter ou modifier un registre de juge de naissance
    @Override
    public void addOrUpdateRegistre(RegistreJugeNaiss registre) {
        if(jugeNaissanceRegistreRep.findRegistreNaissByAnneeAndPartie
                (registre.getAnnee(),registre.getPartie()) != null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Le registre de juge de naissance %d/%d existe deja",registre.getPartie(),registre.getAnnee()));

        if(registre.getPartie() > 1){
            RegistreJugeNaiss dernier =
                    jugeNaissanceRegistreRep.findRegistreNaissByAnneeAndPartie(registre.getAnnee(),registre.getPartie() - 1);
            if(dernier == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Le registre de juge de naissance %d/%d ne peut pas etre cree avant le registre %d/%d",
                                registre.getPartie(),registre.getAnnee(),registre.getPartie()-1,registre.getAnnee()));

            }
        }
        jugeNaissanceRegistreRep.save(registre);

    }
}
