package com.civil.project.rest;

import com.civil.project.entity.RegistreJugeNaiss;
import com.civil.project.service.RegistreJugeNaissance;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugeNaissance")
@RequiredArgsConstructor
public class RegistreJugeNaissanceRest {
    private final RegistreJugeNaissance jugeNaissance;

//////////////////////////partie registre de jug de naissance

    //rechercher le registre de juge de naissance a partir de l'année
    @GetMapping("/registre/juge/naissance/{date}")
    public List<RegistreJugeNaiss> getRegistrBydate(@PathVariable int date){
        return jugeNaissance.findByDate(date);
    }

    // afficher tous les registre de juge de naissance
    @GetMapping("/registre/juge/naissance")
    public List<RegistreJugeNaiss> findRegistres() {
        System.out.println("hey ");
        return jugeNaissance.findRegistres();
    }
    //afficher le registre de juge de naissance a partir de ID de registre
    @GetMapping("/registe/juge/naissance/{idRegistre}")
    public RegistreJugeNaiss getRegistres(@PathVariable int idActe)
    {
        return jugeNaissance.findByIdRegistre(idActe);
    }

    //supprimrer le registre de juge de naissance a partir de ID du Registre
    @DeleteMapping("/registre/juge/naissance/delete/{id}")
    public String deleteRegistre(@PathVariable int id)
    {
        jugeNaissance.deleteActe(id);
        return "delete done";
    }

    //ajouter un registre de naissance
    @PostMapping("/registre/juge/naissance/add")
    public String addRegistre(@RequestBody RegistreJugeNaiss registre)
    {
        jugeNaissance.addOrUpdateRegistre(registre);
        return "add done";
    }

    //modifier un registre de juge de naissance
    @PutMapping("/registre/juge/naissance/update")
    public String UpdateRegistre(@RequestBody RegistreJugeNaiss registre)
    {
        jugeNaissance.addOrUpdateRegistre(registre);
        return "update registre ";
    }

}
