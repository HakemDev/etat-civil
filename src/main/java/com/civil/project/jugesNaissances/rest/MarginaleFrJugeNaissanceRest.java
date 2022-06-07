package com.civil.project.jugesNaissances.rest;

import com.civil.project.jugesNaissances.entity.MargJugeNaissFr;
import com.civil.project.jugesNaissances.service.MarginaleFrJugeNaissanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/marginales-juges-naissances-fr")
@RequiredArgsConstructor
@CrossOrigin
public class MarginaleFrJugeNaissanceRest {
    private final MarginaleFrJugeNaissanceService jugeNaissance;

/////////////////////////////Partie Marginale Frabe de juge de naissance

    //ajouter marginal arabic de juge de naissance
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MargJugeNaissFr save(@RequestBody MargJugeNaissFr margJugeNaissFr) {
        return jugeNaissance.AjouterOuModifierMargFR(margJugeNaissFr);
    }


    @PutMapping("")
    public MargJugeNaissFr updateMarg(@RequestBody MargJugeNaissFr margJugeNaissFr) {
        return jugeNaissance.updateMarg(margJugeNaissFr);
    }


    //supprimer marginal arabic de juge de naissance
    @DeleteMapping("/{id}")
    public void deleteMarg_ar(@PathVariable String idMargeJuge){
        jugeNaissance.SupprimerMargFR(Integer.parseInt(idMargeJuge));
    }

    //chercher le marginal arabic de juge de naissance a partir de id acte de juge de naissance
    @GetMapping("")
    public List<MargJugeNaissFr> listByActeIdMargar(@RequestParam(required = false) String idJuge){

        try {
            if(idJuge == null)
                return jugeNaissance.afficherMarginalFr();

            return jugeNaissance.MargFrByIdActeJugeNaissance(Integer.parseInt(idJuge));
        }   catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide.");
        }
    }

    //chercher le marginal arabic de juge de naissance a partir de id du marginale de juge de naissance
    @GetMapping("/{id}")
    public MargJugeNaissFr listByIdMargar(@PathVariable String id){
        return jugeNaissance.MargFrById(Integer.parseInt(id));
    }


}
