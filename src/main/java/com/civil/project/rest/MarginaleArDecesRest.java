package com.civil.project.rest;

import com.civil.project.entity.MarginaleDecesAr;
import com.civil.project.entity.RegistreDeces;
import com.civil.project.service.MarginaleArDecesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deces")
@RequiredArgsConstructor

public class MarginaleArDecesRest {

   private final MarginaleArDecesService service;

    @PostMapping("/MarginaleAr/save")
    public void save(@RequestBody MarginaleDecesAr registreDeces){
        service.ajouterMargArD(registreDeces);
    }

    @PostMapping("/MarginaleAr/update")
    public void update(@RequestBody MarginaleDecesAr acteDeces){
        service.modifierMargArD(acteDeces);
    }



    @GetMapping("/MarginaleAr/{id}")
    MarginaleDecesAr getById(@PathVariable int id){
        return service.trouverParId(id);
    }

    @DeleteMapping("/MarginaleAr/delete/{id}")
    void suppById(@PathVariable int id){
        service.supprimer(id);
    }

}
