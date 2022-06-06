package com.civil.project.deces.rest;

import com.civil.project.deces.entity.MarginaleDecesFr;
import com.civil.project.deces.service.MarginaleDecesFrService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/marginales-deces-fr")
@RequiredArgsConstructor
@CrossOrigin
public class MarginaleFrDecesRest {

    private final MarginaleDecesFrService service;


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MarginaleDecesFr addMarginaleFr(@RequestBody MarginaleDecesFr margNaisFr) {
        return service.addMarg(margNaisFr);
    }

    @GetMapping("")
    public List<MarginaleDecesFr> getMarginalesFr(@RequestParam(required = false,
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
    public MarginaleDecesFr updateMarginaleFr(@RequestBody MarginaleDecesFr margNaisAr) {
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
