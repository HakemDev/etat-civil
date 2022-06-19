package com.civil.project.jugesDeces.rest;

import com.civil.project.jugesDeces.entity.RegistreJugesDeces;
import com.civil.project.jugesDeces.service.RegistreJugesDecesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/registre-juges-deces")
@RequiredArgsConstructor
@CrossOrigin
public class RegistreJugesDecesRest {

    private final RegistreJugesDecesService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistreJugesDeces addRegistre(@RequestBody RegistreJugesDeces registre){
        return service.addRegistreDeces(registre);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public RegistreJugesDeces updateRegistre(@RequestBody RegistreJugesDeces registre){
        return service.updateRegistreDeces(registre);
    }

    @GetMapping("")
    public List<RegistreJugesDeces> findRegistres(@RequestParam(required = false) Integer annee ){
        return annee != null ? service.findByAnnee(annee) :
                service.getAllRegistreJugesDeces();
    }

    @GetMapping("/{idOrPartieAnnee}")
    public RegistreJugesDeces findByIdOrPartieAnnee(@PathVariable String idOrPartieAnnee) {
        try {
            if(idOrPartieAnnee.matches("[0-9]+-[0-9]{4}")) {
                String[] partieAnnee = idOrPartieAnnee.split("-");
                return service.findRegistreJugeDecesByAnneeAndPartie(
                        Integer.parseInt(partieAnnee[1]),
                        Integer.parseInt(partieAnnee[0])
                );
            }
            return service.getRegistreJugesDecesById(Integer.parseInt(idOrPartieAnnee));
        } catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide.");
        }
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRegistreNaissance(@PathVariable String id) {
        try {
            service.deleteRegistre(Integer.parseInt(id));

        } catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Identificateur invalide.");
        }

    }


}
