package com.civil.project.rest;

import com.civil.project.entity.MargJugeNaissFr;
import com.civil.project.service.MargianleFrJugeNaissanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugeNaissance")
@RequiredArgsConstructor
public class MarginaleFrJugeNaissanceRest {
    private final MargianleFrJugeNaissanceService jugeNaissance;

/////////////////////////////Partie Marginale francais de juge de naissance

    //ajouter marginal francais de juge de naissance
    @PostMapping("/marginal/francais")
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody MargJugeNaissFr margJugeNaissFr){
        jugeNaissance.AjouterOuModifierMargFR(margJugeNaissFr);
        return "marginale francais DE JUGE DE NAISSANCE EST AJOUTE AVEC SUCCESS";
    }

    //afficher les marginales francais de juge de naissance
    @GetMapping("/marginales/francais")
    public List<MargJugeNaissFr> listMarg_fr(){
        return jugeNaissance.afficherMarginalFr();
    }

    //supprimer marginal francais de juge de naissance
    @DeleteMapping("/marginal/francais/{id}")
    public String deleteMarg_fr(@PathVariable String id){
        jugeNaissance.SupprimerMargFR(Integer.parseInt(id));
        return "Marginale de juge de naissance est supprimer";
    }

    //chercher le marginal francais de juge de naissance a partir de id d'acte de juge de naissance
    @GetMapping("/marginales/francais/{id}")
    public List<MargJugeNaissFr> listByActeIdMargfr(@PathVariable String id){
        return jugeNaissance.MargFrByIdActeJugeNaissance(Integer.parseInt(id));
    }

    //chercher le marginal francais de juge de naissance a partir de id du marginale de juge de naissance
    @GetMapping("/marginal/francais/{id}")
    public MargJugeNaissFr listByIdMargfr(@PathVariable String id){
        return jugeNaissance.MargFrById(Integer.parseInt(id));
    }


}
