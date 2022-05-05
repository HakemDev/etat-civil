package com.civil.project.rest;

import com.civil.project.entity.RegistreNaiss;
import com.civil.project.service.User3_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/registre-naissance")
@RequiredArgsConstructor
@CrossOrigin
public class RegistreNaissanceRest {

    private final User3_Service service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistreNaiss addRegistre(@RequestBody RegistreNaiss registre)
    {
        service.addOrUpdateRegistre(registre);
        return registre;
    }


    @GetMapping("")
    public List<RegistreNaiss> findRegistres(@RequestParam(required = false) Integer annee ){
        return annee != null ? service.findByAnnee(annee) :
                service.findRegistres();
    }

    @GetMapping("/{idOrPartieAnnee}")
    public RegistreNaiss findByIdOrPartieAnnee(@PathVariable String idOrPartieAnnee) {
        try {
        if(idOrPartieAnnee.matches("[0-9]+-[0-9]{4}")) {
            String[] partieAnnee = idOrPartieAnnee.split("-");
            return service.findRegistreNaissByAnneeAndPartie(
                    Integer.parseInt(partieAnnee[1]),
                    Integer.parseInt(partieAnnee[0])
            );
        }
            return service.findByIdRegistre(Integer.parseInt(idOrPartieAnnee));
        } catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide.");
        }
    }



}
