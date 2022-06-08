package com.civil.project.statistiques.rest;

import com.civil.project.dto.StatistiqueAdulte;
import com.civil.project.dto.StatistiqueNbrActesSexe;
import com.civil.project.dto.StatistiquePourcentageSexeActes;
import com.civil.project.statistiques.service.StatistiqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Statistique")
@RequiredArgsConstructor
@CrossOrigin
public class StatistiqueRest {

    @Autowired
    private final StatistiqueService statistiqueService;

////////////////////////// Partie statistique

    @GetMapping("/graphes")
    public StatistiquePourcentageSexeActes AfficherGraphe()
        {
            return statistiqueService.graphes();
        }

    @GetMapping("/resumer")
    public StatistiqueNbrActesSexe resume(@RequestParam(required = true) String mois,@RequestParam(required = true) String Annee)
            {
               return statistiqueService.resume(Integer.parseInt(mois),Integer.parseInt(Annee));
            }

    @GetMapping("/enfants")
    public List<StatistiqueAdulte> adulte(@RequestParam(required = true) String ans,@RequestParam(required = true) String Annee)
        {
            return statistiqueService.adulte(Integer.parseInt(ans),Integer.parseInt(Annee));
        }

    @GetMapping("/annuel")
    public List<StatistiqueAdulte> annuel(@RequestParam(required=true) String choix,@RequestParam(required = true) String Annee)
        {
              return statistiqueService.annuel(choix,Integer.parseInt(Annee))  ;
        }
   }