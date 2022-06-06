package com.civil.project.deces.rest;

import com.civil.project.deces.entity.ActeDeces;
import com.civil.project.deces.service.ActeDecesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/deces")
@RequiredArgsConstructor
@CrossOrigin
public class ActeDecesRest {
    private  final ActeDecesService service;

    @PostMapping("")
    public ActeDeces save(@RequestBody ActeDeces acteDeces){
        return service.ajouterActeD(acteDeces);
    }

    @PutMapping("")
    public ActeDeces update(@RequestBody ActeDeces acteDeces){
        return service.modifierActeD(acteDeces);
    }

    @GetMapping("")
    public Collection<ActeDeces> lister(
            @RequestParam(required = false) String nomAr,
            @RequestParam(required = false) String nomFr,
            @RequestParam(required = false) String numero
    ){
        return service.listerActeD(nomAr,nomFr,numero);
    }

    @GetMapping("/{id}")
    public ActeDeces getById(@PathVariable int id){
        try {
            return service.trouverActeDParId(id);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide");
        }

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void suppById(@PathVariable String id){
        try {
            service.supprimerActeD(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide");
        }
    }

}
