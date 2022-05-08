package com.civil.project.jugesDeces.rest;


import com.civil.project.entity.MargNaisAr;
import com.civil.project.jugesDeces.entity.MarginaleJugeDecesAr;
import com.civil.project.jugesDeces.service.MargJugesDecesArService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/marginales-juges-deces-ar")
@CrossOrigin
@RequiredArgsConstructor
public class MargJugesDecesArRest {

    private final MargJugesDecesArService service;


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MarginaleJugeDecesAr addMarginaleAr(@RequestBody MarginaleJugeDecesAr margNaisAr) {
        return service.addMarg(margNaisAr);
    }

    @GetMapping("")
    public List<MarginaleJugeDecesAr> getMarginalesAr(@RequestParam(required = false,
    name = "idJuge") String idActe){
        try {
            if(idActe == null)
                return service.findAllMargJugesDecesAr();

            return service.findMarginalesByIdJuges(Integer.parseInt(idActe));
        } catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide.");
        }
    }

    @PutMapping("")
    public MarginaleJugeDecesAr updateMarginaleAr(@RequestBody MarginaleJugeDecesAr margNaisAr) {
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
