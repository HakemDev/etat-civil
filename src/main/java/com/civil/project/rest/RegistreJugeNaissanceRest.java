package com.civil.project.rest;

import com.civil.project.entity.RegistreJugeNaiss;
import com.civil.project.service.RegistreJugeNaissanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugeNaissance")
@RequiredArgsConstructor
public class RegistreJugeNaissanceRest {
    private final RegistreJugeNaissanceService jugeNaissance;

//////////////////////////partie registre de jug de naissance

    //rechercher le registre de juge de naissance a partir de l'année
    @GetMapping("/registres/annee")
    public List<RegistreJugeNaiss> getRegistrBydate(@RequestParam(required = false) String annee){
        return jugeNaissance.findByDate(Integer.parseInt(annee));
    }

    // afficher tous les registre de juge de naissance
    @GetMapping("/registres/tous")
    public List<RegistreJugeNaiss> findRegistres() {
        return jugeNaissance.findRegistres();
    }

    //afficher le registre de juge de naissance a partir de ID de registre
    @GetMapping("/registe/{idRegistre}")
    public RegistreJugeNaiss getRegistres(@PathVariable int idActe)
    {
        return jugeNaissance.findByIdRegistre(idActe);
    }

    //supprimrer le registre de juge de naissance a partir de ID du Registre
    @DeleteMapping("/{id}")
    public String deleteRegistre(@PathVariable String id)
        {
            jugeNaissance.deleteActe(Integer.parseInt(id));
            return "delete done";
        }

    //ajouter un registre de naissance
    @PostMapping("/registre")
    @ResponseStatus(HttpStatus.CREATED)
    public String addRegistre(@RequestBody RegistreJugeNaiss registre)
    {
        jugeNaissance.addOrUpdateRegistre(registre);
        return "add done";
    }

    //modifier un registre de juge de naissance
    @PutMapping("/registre")
    public String UpdateRegistre(@RequestBody RegistreJugeNaiss registre)
    {
        jugeNaissance.addOrUpdateRegistre(registre);
        return "update registre ";
    }

}
