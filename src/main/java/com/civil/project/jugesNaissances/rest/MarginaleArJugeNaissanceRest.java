package com.civil.project.jugesNaissances.rest;

import com.civil.project.jugesNaissances.entity.MargJugeNaissAr;
import com.civil.project.jugesNaissances.service.MarginaleArJugeNaissanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/marginales-juges-naissances-ar")
@RequiredArgsConstructor
@CrossOrigin
public class MarginaleArJugeNaissanceRest {
    private final MarginaleArJugeNaissanceService jugeNaissance;

/////////////////////////////Partie Marginale Arabe de juge de naissance

    //ajouter marginal arabic de juge de naissance
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MargJugeNaissAr save(@RequestBody MargJugeNaissAr margJugeNaissAr) {
        return jugeNaissance.AjouterOuModifierMargAr(margJugeNaissAr);
    }


    @PutMapping("")
    public MargJugeNaissAr updateMarg(@RequestBody MargJugeNaissAr margJugeNaissAr) {
        return jugeNaissance.updateMarg(margJugeNaissAr);
    }



    //supprimer marginal arabic de juge de naissance
    @DeleteMapping("/{id}")
    public void deleteMarg_ar(@PathVariable String id){
        jugeNaissance.SupprimerMargAr(Integer.parseInt(id));
    }

    //chercher le marginal arabic de juge de naissance a partir de id acte de juge de naissance
    @GetMapping("")
    public List<MargJugeNaissAr> listByActeIdMargar(@RequestParam(required = false) String idJuge){

        try {
            if(idJuge == null)
                return jugeNaissance.afficherMarginalAr();

            return jugeNaissance.MargArByIdActeJugeNaissance(Integer.parseInt(idJuge));
        }   catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide.");
        }
    }

    //chercher le marginal arabic de juge de naissance a partir de id du marginale de juge de naissance
    @GetMapping("/{id}")
    public MargJugeNaissAr listByIdMargar(@PathVariable String id){
        return jugeNaissance.MargArById(Integer.parseInt(id));
    }


}
