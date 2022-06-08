package com.civil.project.jugesNaissances.service;

import com.civil.project.jugesNaissances.dao.JugeNaissanceActeRep;
import com.civil.project.jugesNaissances.dao.JugeNaissanceMargArRep;
import com.civil.project.jugesNaissances.dao.JugeNaissanceMargFrRep;
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
    private final JugeNaissanceMargArRep margArRep;
    private final JugeNaissanceMargFrRep margFrRep;


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
            if(acteJugeNaissance.getNumeroActe() == acte.getNumeroActe()
                && acteJugeNaissance.getIdNaissance() != acte.getIdNaissance()
            ){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("L'acte numero %d dans le registre de juge de naissance %d/%d existe deja",
                                acteJugeNaissance.getNumeroActe(),
                                acteJugeNaissance.getRegistreJugeNaiss().getAnnee(),
                                acteJugeNaissance.getRegistreJugeNaiss().getPartie()));
            }
        }

        registreJugeNaiss.setNombreActes(registreJugeNaiss.getNombreActes() + 1);
        if(acteJugeNaissance.getRegistreJugeNaiss().getIdRegistre() == 0)
            acteJugeNaissance.setRegistreJugeNaiss(registreJugeNaiss);
        return jugeNaissanceActeRep.save(acteJugeNaissance);
    }

    @Override
    public List<ActeJugeNaissancee> afficherActeJugeNaiss() {
        return jugeNaissanceActeRep.findAll();
    }

    @Override
    public void SupprimerActeJugeNaiss(int idActeJugeNais) {

        margArRep.deleteAll(margArRep.findByActeNaissanceIdNaissance(idActeJugeNais));
        margFrRep.deleteAll(margFrRep.findByActeNaissanceIdNaissance(idActeJugeNais));
        jugeNaissanceActeRep.deleteById(idActeJugeNais);
    }

    @Override
    public ActeJugeNaissancee ActeJugeNaiss(int id) {

        Optional<ActeJugeNaissancee> resultat=jugeNaissanceActeRep.findById(id);
        if(resultat.isPresent()) {
          return resultat.get();
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte de juge de naissance non trouve");
        }
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

            if(!numero.matches("[0-9]+/[0-9]{4}")){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Numero de registre invalide");
            }

            String[] partieAnnee = numero.split("/");
            RegistreJugeNaiss registreJugeNaiss = jugeNaissanceRegistreRep.findRegistreNaissByAnneeAndPartie(
                    Integer.parseInt(partieAnnee[1]),
                    Integer.parseInt(partieAnnee[0])
            );
            byNumero = registreJugeNaiss != null ?
                    registreJugeNaiss.getActesjugenaissancee() : new ArrayList<>();
        }


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

        Optional<ActeJugeNaissancee> byId = jugeNaissanceActeRep.findById(acteJugeNaissancee.getIdNaissance());
        if( !byId.isPresent() ) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte de juge de naissance non existant");
        }

        return AjouterOuModifierActeJugNaissa(acteJugeNaissancee);
    }
}
