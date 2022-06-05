package com.civil.project.jugesNaissances.service;

import com.civil.project.jugesNaissances.dao.JugeNaissanceActeRep;
import com.civil.project.jugesNaissances.dao.JugeNaissanceRegistreRep;
import com.civil.project.jugesNaissances.entity.ActeJugeNaissancee;
import com.civil.project.jugesNaissances.entity.RegistreJugeNaiss;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@RequiredArgsConstructor
    public class ActeJugeNaissanceServiceImpl implements ActeJugeNaissanceService{
    private final JugeNaissanceActeRep jugeNaissanceActeRep;
    private final JugeNaissanceRegistreRep jugeNaissanceRegistreRep;

    @Override
    public ActeJugeNaissancee AjouterOuModifierActeJugNaissa(ActeJugeNaissancee acteJugeNaissance) {
        RegistreJugeNaiss registreJugeNaiss = jugeNaissanceRegistreRep.findRegistreNaissByAnneeAndPartie(
                acteJugeNaissance.getRegistreJugeNaiss().getAnnee(),
                acteJugeNaissance.getRegistreJugeNaiss().getPartie()
        );

        if(registreJugeNaiss == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Le registre %d/%d n'exsite pas",
                            acteJugeNaissance.getRegistreJugeNaiss().getAnnee(),
                            acteJugeNaissance.getRegistreJugeNaiss().getPartie()));
        }

        for(ActeJugeNaissancee acte : registreJugeNaiss.getActesjugenaissancee()) {
            if(acteJugeNaissance.getNumeroActe() == acte.getNumeroActe()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("L'acte numero %d dans le registre de juge de naissance %d/%d existe deja",
                                acteJugeNaissance.getNumeroActe(),
                                acteJugeNaissance.getRegistreJugeNaiss().getAnnee(),
                                acteJugeNaissance.getRegistreJugeNaiss().getPartie()));
            }
        }

        registreJugeNaiss.setNombreActes(registreJugeNaiss.getNombreActes() + 1);

        acteJugeNaissance.setRegistreJugeNaiss(registreJugeNaiss);
        return jugeNaissanceActeRep.save(acteJugeNaissance);
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte de juge de naissance non trouve");
        }
        return acteJugeNaissancee;
    }

    @Override
    public List<ActeJugeNaissancee> findActesJugeNaissance(String nomAr, String nomFr, String numero) {
        List<ActeJugeNaissancee> byNomAr = null, byNomFr = null;
        List<ActeJugeNaissancee> byNumero = null;

        if(nomAr != null) {
            byNomAr = jugeNaissanceActeRep.findByNomAr(nomAr);
        }

        if(nomFr != null) {
            byNomFr = jugeNaissanceActeRep.findByNomFr(nomFr);
        }

        if(numero != null){
            System.out.println("3333");

            String[] partieAnnee = numero.split("/");
            RegistreJugeNaiss registreJugeNaiss = jugeNaissanceRegistreRep.findRegistreNaissByAnneeAndPartie(
                    Integer.parseInt(partieAnnee[1]),
                    Integer.parseInt(partieAnnee[0])
            );
            byNumero = registreJugeNaiss != null ?
                    registreJugeNaiss.getActesjugenaissancee() : new ArrayList<>();
        }
        System.out.println("11111");

        List<ActeJugeNaissancee> result =jugeNaissanceActeRep.findAll();

        if(byNomAr != null) result.retainAll(byNomAr);
        if(byNomFr != null) result.retainAll(byNomFr);
        if(byNumero != null) result.retainAll(byNumero);

        return result;
    }

    @Override
    public ActeJugeNaissancee ModifierActeJugNaissa(ActeJugeNaissancee acteJugeNaissancee) {

        if(acteJugeNaissancee == null)
            {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"acte de juge de naissance manque d'info");
            }

        ActeJugeNaissancee acteJugeNaissancee1=ActeJugeNaiss(acteJugeNaissancee.getIdNaissance());
        if( acteJugeNaissancee1==null)
            {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte de juge de nsaissance non existant");
            }

        return AjouterOuModifierActeJugNaissa(acteJugeNaissancee);
    }
}
