package com.civil.project.deces.rest;

import com.civil.project.deces.entity.RegistreDeces;
import com.civil.project.deces.service.RegistreDecesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/registre-actes-deces")
@RequiredArgsConstructor
@CrossOrigin
public class RegistreDecesRest {

    private final RegistreDecesService service;

    @PostMapping("")
    public RegistreDeces save(@RequestBody RegistreDeces registreDeces){
        return service.ajouterRegistreD(registreDeces);
    }

    @PutMapping("")
    public RegistreDeces update(@RequestBody RegistreDeces acteDeces){
        return service.modifierRegistreD(acteDeces);
    }

    @GetMapping("")
    public List<RegistreDeces> lister(){
        return service.listerRegistreD();
    }

    @GetMapping("/{idOrPartieAnnee}")
    public RegistreDeces getByIdOrDateAnnee(@PathVariable String idOrPartieAnnee){
        try {
            if(idOrPartieAnnee.matches("[0-9]+-[0-9]{4}")) {
                String[] partieAnnee = idOrPartieAnnee.split("-");
                return service.findRegistreDecesByAnneeAndPartie(
                        Integer.parseInt(partieAnnee[1]),
                        Integer.parseInt(partieAnnee[0])
                );
            } else {
                return service.trouverParId(Integer.parseInt(idOrPartieAnnee));
            }
        } catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide.");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void suppById(@PathVariable int id){
        service.supprimerRegistreD(id);
    }



}
