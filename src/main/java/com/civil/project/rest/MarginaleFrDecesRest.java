package com.civil.project.rest;

import com.civil.project.entity.MarginaleDecesAr;
import com.civil.project.entity.MarginaleDecesFr;
import com.civil.project.service.MarginaleArDecesService;
import com.civil.project.service.MarginaleFrDecesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deces")
@RequiredArgsConstructor
public class MarginaleFrDecesRest {
    private final MarginaleFrDecesService service;

    @PostMapping("/MarginaleFr/save")
    public void save(@RequestBody MarginaleDecesFr registreDeces){
        service.ajouterMargFrD(registreDeces);
    }

    @PostMapping("/MarginaleFr/update")
    public void update(@RequestBody MarginaleDecesFr acteDeces){
        service.modifierMargFrD(acteDeces);
    }



    @GetMapping("/MarginaleFr/{id}")
    MarginaleDecesFr getById(@PathVariable int id){
        return service.trouverParId(id);
    }

    @DeleteMapping("/MarginaleFr/delete/{id}")
    void suppById(@PathVariable int id){
        service.supprimer(id);
    }
}
