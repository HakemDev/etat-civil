package com.civil.project.naissances.rest;

import com.civil.project.naissances.entity.RegistreNaiss;
import com.civil.project.naissances.service.RegistreNaissService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/registre-naissance")
@RequiredArgsConstructor
@CrossOrigin
public class RegistreNaissanceRest {

    private final RegistreNaissService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistreNaiss addRegistre(@RequestBody RegistreNaiss registre)
    {
        return service.addRegistre(registre);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistreNaiss updateRegistre(@RequestBody RegistreNaiss registre)
    {
        return service.updateRegistre(registre);
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

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRegistreNaissance(@PathVariable String id) {
        try {
            service.deleteRegistre(Integer.parseInt(id));

        } catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide.");
        }

    }



}
