package com.civil.project.rest;

import com.civil.project.entity.Commune;
import com.civil.project.service.CommuneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/commune")
public class CommuneRest {
    private final CommuneService communeService;

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

