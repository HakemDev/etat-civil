package com.civil.project.statistiques.service;

import com.civil.project.dto.StatistiqueAdulte;
import com.civil.project.dto.StatistiqueNbrActesSexe;
import com.civil.project.dto.StatistiquePourcentageSexeActes;

import java.util.List;

public interface StatistiqueService {

    StatistiquePourcentageSexeActes graphes();
    StatistiqueNbrActesSexe resume(int mois, int annee);

    List<StatistiqueAdulte> adulte(int ans, int annee);

    List<StatistiqueAdulte> annuel(String choix, int annee);
}
