package com.civil.project.naissances.rest;



import com.civil.project.naissances.entity.ActeNaissance;
import com.civil.project.naissances.service.ActeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;


@RestController
@RequestMapping("/acte")
@RequiredArgsConstructor
@CrossOrigin
public class ActeNaissanceRest {

    private final ActeService acteService;

    @PostMapping("")
    public ActeNaissance addActe(@RequestBody ActeNaissance acteNaissance) {
        return acteService.addActe(acteNaissance);
    }

    @GetMapping("")
    public Collection<ActeNaissance> searchActe(
            @RequestParam(required = false) String nomAr,
            @RequestParam(required = false) String nomFr,
            @RequestParam(required = false) String numero
    ) {
        return acteService.findActes(nomAr,nomFr,numero);
    }

    @GetMapping("/{idActe}")
    public ActeNaissance findActeById(@PathVariable String idActe) {
        try {
            return acteService.findActeById(Integer.parseInt(idActe));
        }
        catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide");
        }
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ActeNaissance updateActe(@RequestBody ActeNaissance acteNaissance) {
       return acteService.updateActe(acteNaissance);
    }

    @DeleteMapping("/{idActe}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteActe(@PathVariable String idActe) {
        try {
            acteService.deleteActe(Integer.parseInt(idActe));
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide");
        }
    }
}


