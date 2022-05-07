package com.civil.project.rest;

import com.civil.project.entity.ActeDeces;
import com.civil.project.entity.RegistreDeces;
import com.civil.project.service.RegistreDecesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deces")
@RequiredArgsConstructor
public class RegistreDecesRest {

    private final RegistreDecesService service;

    @PostMapping("/registre/save")
    public void save(@RequestBody RegistreDeces registreDeces){
        service.ajouterRegistreD(registreDeces);
    }

    @PostMapping("/registre/update")
    public void update(@RequestBody RegistreDeces acteDeces){
        service.modifierRegistreD(acteDeces);
    }

    @GetMapping("/registre/list")
    List<RegistreDeces> lister(){
        return service.listerRegistreD();
    }

    @GetMapping("/registre/{id}")
    RegistreDeces getById(@PathVariable int id){
        return service.trouverParId(id);
    }

    @DeleteMapping("/registre/delete/{id}")
    void suppById(@PathVariable int id){
        service.supprimerRegistreD(id);
    }



}
