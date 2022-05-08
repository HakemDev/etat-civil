package com.civil.project.rest;

import com.civil.project.entity.ActeJugeNaissancee;
import com.civil.project.entity.ActeNaissance;
import com.civil.project.service.ActeJugeNaissanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/jugeNaissance")
@RequiredArgsConstructor
public class ActeJugeNaissanceRest {

    private final ActeJugeNaissanceService jugeNaissance;


/////////////////////////////Partie Acte de juge de naissance

    //ajouter acte de juge de naissance
    @PostMapping("/acte")
    public ActeJugeNaissancee save(@RequestBody ActeJugeNaissancee acteJugeNaissance){
        return jugeNaissance.AjouterOuModifierActeJugNaissa(acteJugeNaissance);
    }

    //modifier acte de juge de naissance
    @PutMapping("/acte")
    public ActeJugeNaissancee update(@RequestBody ActeJugeNaissancee acteJugeNaissancee){

        return jugeNaissance.ModifierActeJugNaissa((ActeJugeNaissancee) acteJugeNaissancee);
    }

    //afficher acte de juge de naissance
    @GetMapping("/actes")
    public List<ActeJugeNaissancee> listMarg_ar(){
        return jugeNaissance.afficherActeJugeNaiss();
    }

    //supprimer acte de juge de naissance
    @DeleteMapping("/acte/{id}")
    public String deleteActeJuge(@PathVariable int id){
        jugeNaissance.SupprimerActeJugeNaiss(id);
        return "deleted successfuly";
    }

    //chercher l'acte de naissance a partir de id
    @GetMapping("/acte/{id}")
    public ActeJugeNaissancee listByIdMargar(@PathVariable String id){
        return jugeNaissance.ActeJugeNaiss(Integer.parseInt(id));
    }

    @GetMapping("")
    public List<ActeJugeNaissancee> searchActe(
            @RequestParam(required = false) String nomAr,
            @RequestParam(required = false) String nomFr,
            @RequestParam(required = false) String numero
    )
        {
            System.out.println("nom arabe "+nomAr);
            return jugeNaissance.findActesJugeNaissance(nomAr,nomFr,numero);
        }
}
