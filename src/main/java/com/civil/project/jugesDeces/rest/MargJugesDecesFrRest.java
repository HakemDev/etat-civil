package com.civil.project.jugesDeces.rest;


import com.civil.project.jugesDeces.entity.MarginaleJugeDecesFr;
import com.civil.project.jugesDeces.service.MargJugesDecesFrService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/marginales-juges-deces-fr")
@CrossOrigin
@RequiredArgsConstructor
public class MargJugesDecesFrRest {

    private final MargJugesDecesFrService service;


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MarginaleJugeDecesFr addMarginaleFr(@RequestBody MarginaleJugeDecesFr margNaisFr) {
        return service.addMarg(margNaisFr);
    }

    @GetMapping("")
    public List<MarginaleJugeDecesFr> getMarginalesFr(@RequestParam(required = false,
    name = "idJuge") String idActe){
        try {
            if(idActe == null)
                return service.findAllMargJugesDecesFr();

            return service.findMarginalesByIdJuges(Integer.parseInt(idActe));
        } catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide.");
        }
    }

    @PutMapping("")
    public MarginaleJugeDecesFr updateMarginaleFr(@RequestBody MarginaleJugeDecesFr margNaisAr) {
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
