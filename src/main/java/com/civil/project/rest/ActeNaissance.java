package com.civil.project.rest;



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
public class ActeNaissance {

    private final ActeService acteService;

    @PostMapping("")
    public com.civil.project.entity.ActeNaissance addActe(@RequestBody com.civil.project.entity.ActeNaissance acteNaissance) {


        return acteService.addActe(acteNaissance);
    }

    @GetMapping("")
    public Collection<com.civil.project.entity.ActeNaissance> searchActe(
            @RequestParam(required = false) String nomAr,
            @RequestParam(required = false) String nomFr,
            @RequestParam(required = false) String numero
    ) {
        return acteService.findActes(nomAr,nomFr,numero);
    }

    @GetMapping("/{idActe}")
    public com.civil.project.entity.ActeNaissance findActeById(@PathVariable String idActe) {
        try {
            return acteService.findActeById(Integer.parseInt(idActe));
        }
        catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide");
        }
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public com.civil.project.entity.ActeNaissance updateActe(@RequestBody com.civil.project.entity.ActeNaissance acteNaissance) {
       return acteService.updateActe(acteNaissance);
    }

    public void deleteActe(Integer idActe) {
        acteService.deleteActe(idActe);
    }
}


