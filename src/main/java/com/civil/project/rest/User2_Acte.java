package com.civil.project.rest;



import com.civil.project.entity.ActeNaissance;
import com.civil.project.service.ActeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;


@RestController
@RequestMapping("/acte")
@RequiredArgsConstructor
@CrossOrigin
public class User2_Acte {

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

    public void deleteActe(Integer idActe) {
        acteService.deleteActe(idActe);
    }
}


