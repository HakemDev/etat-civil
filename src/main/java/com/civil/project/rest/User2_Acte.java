package com.civil.project.rest;

import com.civil.project.dao.NaissanceRegistreRep_user3;
import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.RegistreNaiss;
import com.civil.project.service.User2_ActeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    public ActeNaissance updateActe(ActeNaissance acteNaissance) {
       return acteService.updateActe(acteNaissance);
    }

    public void deleteActe(Integer idActe) {
        acteService.deleteActe(idActe);
    }
}



