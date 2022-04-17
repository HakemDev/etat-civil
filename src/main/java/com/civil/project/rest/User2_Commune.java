package com.civil.project.rest;

import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.Commune;
import com.civil.project.service.User2_ActeService;
import com.civil.project.service.User2_CommuneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/commune")
public class User2_Commune {
    private final User2_CommuneService communeService;

    public Commune addActe(Commune commune) {

        return communeService.addCommune(commune);
    }

    public Commune updateActe(Commune commune) {
        return communeService.updateCommune(commune);
    }

    public void deleteActe(Integer idActe) {
        communeService.deleteCommune(idActe);
    }
}
