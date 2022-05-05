package com.civil.project.rest;

import com.civil.project.entity.MargJugeNaissFr;
import com.civil.project.service.MargianleFrJugeNaissanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugeNaissance")
@RequiredArgsConstructor
public class MarginaleFrJugeNaissanceRest {
    private final MargianleFrJugeNaissanceService jugeNaissance;

/////////////////////////////Partie Marginale francais de juge de naissance

    //ajouter marginal francais de juge de naissance
    @PostMapping("/marginal/juge/naissance/fr/ajouter")
    public String save(@RequestBody MargJugeNaissFr margJugeNaissFr){
        jugeNaissance.AjouterOuModifierMargFR(margJugeNaissFr);
        return "marginale francais DE JUGE DE NAISSANCE EST AJOUTE AVEC SUCCESS";
    }

    //afficher les marginales francais de juge de naissance
    @GetMapping("/marginal/juge/naissance/fr/list")
    public List<MargJugeNaissFr> listMarg_fr(){
        return jugeNaissance.afficherMarginalFr();
    }

    //supprimer marginal francais de juge de naissance
    @DeleteMapping("/marginal/juge/naissance/fr/delete/{id}")
    public String deleteMarg_fr(@PathVariable int idMarginal){
        jugeNaissance.SupprimerMargFR(idMarginal);
        return "Marginale de juge de naissance est supprimer";
    }

    //chercher le marginal francais de juge de naissance a partir de id d'acte de juge de naissance
    @GetMapping("/marginal/juge/naissance/fr/IdActe/{id}")
    public List<MargJugeNaissFr> listByActeIdMargfr(@PathVariable int idActeJugeNaissa){
        return jugeNaissance.MargFrByIdActeJugeNaissance(idActeJugeNaissa);
    }

    //chercher le marginal francais de juge de naissance a partir de id du marginale de juge de naissance
    @GetMapping("/marginal/juge/naissance/afr/{id}")
    public MargJugeNaissFr listByIdMargfr(@PathVariable int id){
        return jugeNaissance.MargFrById(id);
    }


}
