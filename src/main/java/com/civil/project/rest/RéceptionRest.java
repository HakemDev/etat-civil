package com.civil.project.rest;

import com.civil.project.dto.Reception;
import com.civil.project.entity.ActeJugeNaissancee;
import com.civil.project.service.ActeJugeNaissance;
import com.civil.project.service.ReceptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reception")
@RequiredArgsConstructor
public class RéceptionRest {

    private final ReceptionService receptionService;
/////////////////////////////Partie Reception

    //AFFICHER LE POURCENTAGE DE CHAQUE ACTE
    @GetMapping("/pourcentage/actes/global")
    public Reception listByIdMargar(){
        return receptionService.PourcentagActeGlobal();
    }
}
