package com.civil.project.deces.service;

import com.civil.project.deces.dao.DecesActeRep;
import com.civil.project.deces.dao.DecesRegistreRep;
import com.civil.project.deces.entity.ActeDeces;
import com.civil.project.deces.entity.RegistreDeces;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ActeDecesServiceImpl implements ActeDecesService {



    private final DecesActeRep rep;
    private final DecesRegistreRep decesRegistreRep;


    @Override
    public ActeDeces ajouterActeD(ActeDeces acteDeces) {

        RegistreDeces registreDeces = decesRegistreRep.findByAnneeAndPartie(
                acteDeces.getRegistreDeces().getAnnee(),
                acteDeces.getRegistreDeces().getPartie()
        );


        if(registreDeces == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Le registre %d/%d n'exsite pas",
                            acteDeces.getRegistreDeces().getAnnee(),
                            acteDeces.getRegistreDeces().getPartie()));
        }

        for(ActeDeces acte : registreDeces.getActesDeces())  {
            if(acte.getNumDeces() == acteDeces.getNumDeces()
            && acteDeces.getIdDeces() != acte.getIdDeces()
            ) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("L'acte numero %d dans le registre %d/%d existe deja",
                            acte.getNumDeces(),
                            acte.getRegistreDeces().getAnnee(),
                            acte.getRegistreDeces().getPartie()));
        }

        registreDeces.setNombreActeDeces(registreDeces.getNombreActeDeces() + 1);
        registreDeces.setDernierNumero(acteDeces.getNumDeces());

        if(acteDeces.getRegistreDeces().getIdRegistreDeces() == 0)
            acteDeces.setRegistreDeces(registreDeces);

        return rep.save(acteDeces);
    }

    @Override
    public ActeDeces modifierActeD(ActeDeces acteDeces) {

        if(acteDeces == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Acte invalide");
        }

        if( !rep.findById(acteDeces.getIdDeces()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte non existant");
        }

        return rep.save(acteDeces);
    }

    @Override
    public ActeDeces trouverActeDParId(int i) {
        Optional<ActeDeces> result=rep.findById(i);
        if( !result.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte non trouve");
        return result.get();
    }


    @Override
    public Set<ActeDeces> listerActeD(String nomAr, String nomFr, String numero) {
        Set<ActeDeces> byNomAr = null, byNomFr = null;
        List<ActeDeces> byNumero = null;

        if(nomAr != null) {
            byNomAr = rep.findActeDecesByNomAr(nomAr);
        }

        if(nomFr != null) {
            byNomFr = rep.findActeDecesByNomFr(nomFr);
        }

        if(numero != null) {
            String[] partieAnnee = numero.split("/");
            RegistreDeces registreDeces = decesRegistreRep.findByAnneeAndPartie(
                    Integer.parseInt(partieAnnee[1]),
                    Integer.parseInt(partieAnnee[0])
            );
            byNumero = registreDeces != null ?
                    registreDeces.getActesDeces() : new ArrayList<>();
        }

        Set<ActeDeces> result = new HashSet<>(rep.findAll());
        if(byNomAr != null) result.retainAll(byNomAr);
        if(byNomFr != null) result.retainAll(byNomFr);
        if(byNumero != null) result.retainAll(byNumero);

        return result;
    }

    @Override
    public void supprimerActeD(int i) { rep.deleteById(i); }
}
