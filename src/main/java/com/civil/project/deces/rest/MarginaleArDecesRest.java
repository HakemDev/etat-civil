package com.civil.project.deces.rest;

import com.civil.project.deces.entity.MarginaleDecesAr;
import com.civil.project.deces.service.MarginaleDecesArService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/marginales-deces-ar")
@RequiredArgsConstructor
@CrossOrigin
public class MarginaleArDecesRest {

    private final MarginaleDecesArService service;


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MarginaleDecesAr addMarginaleAr(@RequestBody MarginaleDecesAr margNaisAr) {
        return service.addMarg(margNaisAr);
    }

    @GetMapping("")
    public List<MarginaleDecesAr> getMarginalesAr(@RequestParam(required = false,
            name = "idActe") String idActe){
        try {
            if(idActe == null)
                return service.findAll();

            return service.findMarginaleByIdActe(Integer.parseInt(idActe));
        } catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide.");
        }
    }

    @PutMapping("")
    public MarginaleDecesAr updateMarginaleAr(@RequestBody MarginaleDecesAr margNaisAr) {
        return service.updateMarg(margNaisAr);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMarg_ar(@PathVariable String id) {
        try {
            service.deleteMarg(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificateur invalide.");
        }
    }
}
