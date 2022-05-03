package com.civil.project.rest;

import com.civil.project.entity.ActeJugeNaissancee;
import com.civil.project.service.ActeJugeNaissance;
import com.civil.project.service.MarginaleArJugeNaissance;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugeNaissance")
@RequiredArgsConstructor
public class ActeJugeNaissanceRest {

    private final ActeJugeNaissance jugeNaissance;


/////////////////////////////Partie Acte de juge de naissance

    //ajouter acte de juge de naissance
    @PostMapping("/acte/juge/naissance/save")
    public String save(@RequestBody ActeJugeNaissancee acteJugeNaissance){
        jugeNaissance.AjouterOuModifierActeJugNaissa(acteJugeNaissance);
        return "acte de juge de naissance est bien ajouté";
    }

    //modifier acte de juge de naissance
    @PutMapping("/acte/juge/naissance/update")
    public String update(@RequestBody ActeJugeNaissance acteJugeNaissancee){
        jugeNaissance.AjouterOuModifierActeJugNaissa((ActeJugeNaissancee) acteJugeNaissancee);
        return "acte de juge de naissance est bien modifie";
    }

    //afficher acte de juge de naissance
    @GetMapping("/acte/juge/naissance/list")
    public List<ActeJugeNaissancee> listMarg_ar(){
        return jugeNaissance.afficherActeJugeNaiss();
    }

    //supprimer acte de juge de naissance
    @DeleteMapping("/acte/juge/naissance/delete/{id}")
    public String deleteMarg_ar(@PathVariable int idActeJugeNais){
        jugeNaissance.SupprimerActeJugeNaiss(idActeJugeNais);
        return "deleted successfuly";
    }

    //chercher l'acte de naissance a partir de id
    @GetMapping("/acte/juge/naissance/{id}")
    public ActeJugeNaissancee listByIdMargar(@PathVariable int id){
        return jugeNaissance.ActeJugeNaiss(id);
    }

}
