
package com.civil.project.rest;

import com.civil.project.entity.MargNaisFr;
import com.civil.project.service.MarginalesFrService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/marginales-fr")
@CrossOrigin
@RequiredArgsConstructor
public class MarginalesFrRest {

    private final MarginalesFrService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MargNaisFr addMarginaleAr(@RequestBody MargNaisFr margNaisFr) {
        return service.addMarg(margNaisFr);
    }

    @GetMapping("")
    public List<MargNaisFr> getMarginalesFr(@RequestParam(required = false) String idActe){
        try {
            if(idActe == null)
                return service.findAllMargNaisFr();

            return service.findMargNaisFrByIdActe(Integer.parseInt(idActe));
        } catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide.");
        }
    }

}
