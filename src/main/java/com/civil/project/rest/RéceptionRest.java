package com.civil.project.rest;

import com.civil.project.dto.Reception;
import com.civil.project.service.ReceptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reception")
@RequiredArgsConstructor
@CrossOrigin
public class RéceptionRest {

    private final ReceptionService receptionService;
/////////////////////////////Partie Reception

     //AFFICHER LE NOMBRE DE CHAQUE ACTE
    @GetMapping("/nombre/actes_pourcentage/global")
    public Reception NombreActePourcentage(){
        return receptionService.NombregActePourcentageGlobal();
    }

    //AFFICHER LE POURCENTAGE DE CHAQUE ACTE
    @GetMapping("/pourcentage/actes/global")
    public Reception PourcentageActe(){
        return receptionService.PourcentagActeGlobal();
    }

    //AFFICHER LES NOMBRE DES ACTES POR CHAQUE ANNEE
    @GetMapping("/nombre/acte/{annee}")
    public List<Reception> NombreActesAnne(@PathVariable int annee){
        return receptionService.NombreActeAnnee(annee);
    }
}
