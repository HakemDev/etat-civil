package com.civil.project.jugesNaissances.rest;

import com.civil.project.jugesNaissances.entity.RegistreJugeNaiss;
import com.civil.project.jugesNaissances.service.RegistreJugeNaissanceService;
import com.civil.project.naissances.entity.RegistreNaiss;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/registres-juges-naissance")
@RequiredArgsConstructor
public class RegistreJugeNaissanceRest {


    private final RegistreJugeNaissanceService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistreJugeNaiss addRegistre(@RequestBody RegistreJugeNaiss registre)
    {
        return service.addRegistre(registre);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistreJugeNaiss updateRegistre(@RequestBody RegistreJugeNaiss registre)
    {
        return service.updateRegistre(registre);
    }


    @GetMapping("")
    public List<RegistreJugeNaiss> findRegistres(@RequestParam(required = false) Integer annee ){
        return annee != null ? service.findByAnnee(annee) :
                service.findAll();
    }

    @GetMapping("/{idOrPartieAnnee}")
    public RegistreJugeNaiss findByIdOrPartieAnnee(@PathVariable String idOrPartieAnnee) {
        try {
            if(idOrPartieAnnee.matches("[0-9]+-[0-9]{4}")) {
                String[] partieAnnee = idOrPartieAnnee.split("-");
                return service.findByAnneeAndPartie(
                        Integer.parseInt(partieAnnee[1]),
                        Integer.parseInt(partieAnnee[0])
                );
            }
            return service.findByIdJuge(Integer.parseInt(idOrPartieAnnee));
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
