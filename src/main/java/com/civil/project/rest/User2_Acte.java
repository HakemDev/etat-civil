package com.civil.project.rest;

import com.civil.project.dao.NaissanceRegistreRep_user3;
import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.RegistreNaiss;
import com.civil.project.service.User2_ActeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/acte")
@RequiredArgsConstructor
@CrossOrigin
public class User2_Acte {

    private final User2_ActeService acteService;

    @PostMapping("")
    public ActeNaissance addActe(@RequestBody ActeNaissance acteNaissance) {

        return acteService.addActe(acteNaissance);
    }

    @GetMapping("")
    public Collection<ActeNaissance> serchActe(
            @RequestParam(required = false) String nomAr,
            @RequestParam(required = false) String nomFr,
            @RequestParam(required = false) String numero
    ) {
        return acteService.findActes(nomAr,nomFr,numero);
    }

    public ActeNaissance updateActe(ActeNaissance acteNaissance) {
       return acteService.updateActe(acteNaissance);
    }

    public void deleteActe(Integer idActe) {
        acteService.deleteActe(idActe);
    }
}



