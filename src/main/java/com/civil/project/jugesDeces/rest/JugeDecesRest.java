package com.civil.project.jugesDeces.rest;

import com.civil.project.jugesDeces.entity.JugeDeces;
import com.civil.project.jugesDeces.service.JugesDecesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@RequestMapping("/juge-deces")
@RequiredArgsConstructor
@CrossOrigin
public class JugeDecesRest {

    private final JugesDecesService service;

    @PostMapping("")
    public JugeDeces addJuge(@RequestBody JugeDeces jd) {
        return service.addJuge(jd);
    }

    @GetMapping("")
    public Collection<JugeDeces> searchJuges(
        @RequestParam(required = false) String nomAr,
        @RequestParam(required = false) String nomFr,
        @RequestParam(required = false) String numero
    ) {
        return service.findJuges(nomAr,nomFr,numero);
    }

    @GetMapping("/{idJuge}")
    public JugeDeces findActeById(@PathVariable String idJuge) {
        try {
            return service.findJugeById(Integer.parseInt(idJuge));
        }
        catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide");
        }
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public JugeDeces updateActe(@RequestBody JugeDeces juge) {
        return service.updateJuge(juge);
    }

    @DeleteMapping("/{idActe}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteActe(@PathVariable String idActe) {
        try {
            service.deleteJuge(Integer.parseInt(idActe));
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide");
        }
    }
}
