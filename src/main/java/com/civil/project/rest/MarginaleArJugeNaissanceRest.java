package com.civil.project.rest;

import com.civil.project.entity.MargJugeNaissAr;
import com.civil.project.service.MarginaleArJugeNaissanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugeNaissance")
@RequiredArgsConstructor
public class MarginaleArJugeNaissanceRest {
    private final MarginaleArJugeNaissanceService jugeNaissance;

/////////////////////////////Partie Marginale Arabe de juge de naissance

    //ajouter marginal arabic de juge de naissance
    @PostMapping("/marginal/arabe")
    @ResponseStatus(HttpStatus.CREATED)
    public MargJugeNaissAr save(@RequestBody MargJugeNaissAr margJugeNaissAr)
        {
            return jugeNaissance.AjouterOuModifierMargAr(margJugeNaissAr);
        }

    //afficher les marginales arabic de juge de naissance
    @GetMapping("/marginales/arabe")
    public List<MargJugeNaissAr> listMarg_ar(){
        return jugeNaissance.afficherMarginalAr();
    }

    //supprimer marginal arabic de juge de naissance
    @DeleteMapping("/marginal/arabe/{id}")
    public String deleteMarg_ar(@PathVariable String idMargeJuge){
        jugeNaissance.SupprimerMargAr(Integer.parseInt(idMargeJuge));
        return "deleted successfuly";
    }

    //chercher le marginal arabic de juge de naissance a partir de id acte de juge de naissance
    @GetMapping("/marginales/arabe/{id}")
    public List<MargJugeNaissAr> listByActeIdMargar(@PathVariable String id){
        return jugeNaissance.MargArByIdActeJugeNaissance(Integer.parseInt(id));
    }

    //chercher le marginal arabic de juge de naissance a partir de id du marginale de juge de naissance
    @GetMapping("/marginal/arabe/{id}")
    public MargJugeNaissAr listByIdMargar(@PathVariable String id){
        return jugeNaissance.MargArById(Integer.parseInt(id));
    }


}
