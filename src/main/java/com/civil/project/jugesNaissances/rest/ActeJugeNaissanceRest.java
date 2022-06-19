package com.civil.project.jugesNaissances.rest;

import com.civil.project.jugesNaissances.entity.ActeJugeNaissancee;
import com.civil.project.jugesNaissances.service.ActeJugeNaissanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;

@RestController
@RequestMapping("/api/juges-naissance")
@RequiredArgsConstructor
@CrossOrigin
public class ActeJugeNaissanceRest {

    private final ActeJugeNaissanceService jugeNaissance;

    @PostMapping("")
    public ActeJugeNaissancee save(@RequestBody ActeJugeNaissancee acteJugeNaissance){
        return jugeNaissance.AjouterOuModifierActeJugNaissa(acteJugeNaissance);
    }

    @PutMapping("")
    public ActeJugeNaissancee update(@RequestBody ActeJugeNaissancee acteJugeNaissancee){

        return jugeNaissance.ModifierActeJugNaissa((ActeJugeNaissancee) acteJugeNaissancee);
    }

    @DeleteMapping("/{id}")
    public String deleteActeJuge(@PathVariable int id){
        jugeNaissance.SupprimerActeJugeNaiss(id);
        return "deleted successfuly";
    }

    @GetMapping("/{id}")
    public ActeJugeNaissancee listByIdMargar(@PathVariable String id){
        return jugeNaissance.ActeJugeNaiss(Integer.parseInt(id));
    }

    @GetMapping("")
    public List<ActeJugeNaissancee> searchActe(
            @RequestParam(required = false) String nomAr,
            @RequestParam(required = false) String nomFr,
            @RequestParam(required = false) String numero
    ) {
        return jugeNaissance.findActesJugeNaissance(nomAr,nomFr,numero);
    }
}
