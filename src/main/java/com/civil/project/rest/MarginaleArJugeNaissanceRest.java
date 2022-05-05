package com.civil.project.rest;

import com.civil.project.entity.MargJugeNaissAr;
import com.civil.project.service.MarginaleArJugeNaissanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugeNaissance")
@RequiredArgsConstructor
public class MarginaleArJugeNaissanceRest {
    private final MarginaleArJugeNaissanceService jugeNaissance;

/////////////////////////////Partie Marginale Arabe de juge de naissance

    //ajouter marginal arabic de juge de naissance
    @PostMapping("/marginal/juge/naissance/ar/save")
    public String save(@RequestBody MargJugeNaissAr margJugeNaissAr){
        jugeNaissance.AjouterOuModifierMargAr(margJugeNaissAr);
        return "marginale arabe De Juge de Naissance est bien ajouté";
    }

    //afficher les marginales arabic de juge de naissance
    @GetMapping("/marginal/juge/naissance/ar/list")
    public List<MargJugeNaissAr> listMarg_ar(){
        return jugeNaissance.afficherMarginalAr();
    }

    //supprimer marginal arabic de juge de naissance
    @DeleteMapping("/marginal/juge/naissance/ar/delete/{id}")
    public String deleteMarg_ar(@PathVariable int idMargeJuge){
        jugeNaissance.SupprimerMargAr(idMargeJuge);
        return "deleted successfuly";
    }

    //chercher le marginal arabic de juge de naissance a partir de id acte de juge de naissance
    @GetMapping("/marginal/juge/naissance/ar/IdActe/{id}")
    public List<MargJugeNaissAr> listByActeIdMargar(@PathVariable int id){
        return jugeNaissance.MargArByIdActeJugeNaissance(id);
    }

    //chercher le marginal francais de juge de naissance a partir de id du marginale de juge de naissance
    @GetMapping("/marginal/juge/naissance/ar/{id}")
    public MargJugeNaissAr listByIdMargar(@PathVariable int id){
        return jugeNaissance.MargArById(id);
    }


}
