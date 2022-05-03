package com.civil.project.rest;

import com.civil.project.entity.ActeNaissance;
import com.civil.project.service.User2_ActeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acte")
@RequiredArgsConstructor
public class User2_Acte {

    private final User2_ActeService acteService;

    public ActeNaissance addActe(ActeNaissance acteNaissance) {

        return acteService.addActe(acteNaissance);
    }

    public ActeNaissance updateActe(ActeNaissance acteNaissance) {
        return acteService.updateActe(acteNaissance);
    }

    public void deleteActe(Integer idActe) {
        acteService.deleteActe(idActe);
    }
}


