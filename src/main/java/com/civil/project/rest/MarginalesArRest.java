package com.civil.project.rest;

import com.civil.project.entity.MargNaisAr;
import com.civil.project.service.MarginalesArService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/marginales-ar")
@CrossOrigin
@RequiredArgsConstructor
public class MarginalesArRest {

    private final MarginalesArService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MargNaisAr addMarginaleAr(@RequestBody MargNaisAr margNaisAr) {
        return service.addMarg(margNaisAr);
    }

    @GetMapping("")
    public List<MargNaisAr> getMarginalesAr(@RequestParam(required = false) String idActe){
        try {
            if(idActe == null)
                return service.findAllMargNaisAr();

            return service.findMargNaisArByIdActe(Integer.parseInt(idActe));
        } catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide.");
        }
    }

    @PutMapping("")
    public MargNaisAr updateMarginaleAr(@RequestBody MargNaisAr margNaisAr) {
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
