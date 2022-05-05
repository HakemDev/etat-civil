package com.civil.project.rest;

import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.RegistreNaiss;
import com.civil.project.service.RegistreNaissService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/user3")
public class User3_Rest {

    private RegistreNaissService service;
    @Autowired
    public User3_Rest(RegistreNaissService service) {
        this.service = service;
    }

    @GetMapping("/acte/naissance/{idActe}")
    public ActeNaissance getAct(@PathVariable int idActe)
    {
        return service.findById(idActe);
    }

    @GetMapping("/registre/naissance")
    public List<RegistreNaiss> findRegistres(@RequestParam(required = false) Integer annee ){
        return annee != null ? service.findByAnnee(annee) :
                service.findRegistres();
    }

    @GetMapping("/registre/naissance/{idRegistre}")
    public RegistreNaiss getRegistres(@PathVariable int idRegistre)
    {
        return service.findByIdRegistre(idRegistre);
    }

    @DeleteMapping("/registre/naissance/delete/{id}")
    public String deleteRegistre(@PathVariable int id)
    {
        service.deleteRegistre(id);
        return "delete done";
    }

    @PostMapping("/registre/naissance")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistreNaiss addRegistre(@RequestBody RegistreNaiss registre)
    {
        service.addRegistre(registre);
        return registre;
    }

    @PutMapping("/registre/naissance/update")
    public String UpdateRegistre(@RequestBody RegistreNaiss registre)
    {
        service.addRegistre(registre);
        return "update registre ";
    }

}
