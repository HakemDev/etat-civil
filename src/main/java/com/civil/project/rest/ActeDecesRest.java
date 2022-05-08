package com.civil.project.rest;

import com.civil.project.entity.ActeDeces;
import com.civil.project.service.ActeDecesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deces")
@RequiredArgsConstructor
public class ActeDecesRest {
    private  final ActeDecesService service;

    @PostMapping("/acte/save")
    public void save(@RequestBody ActeDeces acteDeces){
        service.ajouterActeD(acteDeces);
    }

    @PostMapping("/acte/update")
    public void update(@RequestBody ActeDeces acteDeces){
        service.modifierActeD(acteDeces);
    }

    @GetMapping("/acte/list")
    List<ActeDeces> lister(){
        return service.listerActeD();
    }

    @GetMapping("/acte/{id}")
    ActeDeces getById(@PathVariable int id){
        return service.trouverActeDParId(id);
    }

    @DeleteMapping("/acte/delete/{id}")
    void suppById(@PathVariable int id){
        service.supprimerActeD(id);
    }

    






}
