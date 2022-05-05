package com.civil.project.rest;

import com.civil.project.dto.Reception;
import com.civil.project.entity.ActeJugeNaissancee;
import com.civil.project.service.ActeJugeNaissance;
import com.civil.project.service.ReceptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reception")
@RequiredArgsConstructor
public class RéceptionRest {

    private final ReceptionService receptionService;
/////////////////////////////Partie Reception

    //AFFICHER LE NOMBRE DE CHAQUE ACTE
    @GetMapping("/nombre/actes/global")
    public Reception NombreActe(){
        return receptionService.NombregActeGlobal();
    }

    //AFFICHER LE POURCENTAGE DE CHAQUE ACTE
    @GetMapping("/pourcentage/actes/global")
    public Reception PourcentageActe(){
        return receptionService.PourcentagActeGlobal();
    }

    //AFFICHER LES NOMBRE DES ACTES POR CHAQUE ANNEE
    @GetMapping("/nombre/acte/annee")
    public List<Reception> NombreActesAnne(){
        return receptionService.NombreActeAnnee();
    }
}
