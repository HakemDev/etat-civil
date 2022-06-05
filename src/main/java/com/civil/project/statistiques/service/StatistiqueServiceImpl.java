package com.civil.project.statistiques.service;

import com.civil.project.jugesNaissances.dao.JugeNaissanceActeRep;
import com.civil.project.naissances.dao.NaissanceActeRepository;
import com.civil.project.dto.StatistiqueAdulte;
import com.civil.project.dto.StatistiqueNbrActesSexe;
import com.civil.project.dto.StatistiquePourcentageSexeActes;
import com.civil.project.jugesNaissances.entity.ActeJugeNaissancee;
import com.civil.project.naissances.entity.ActeNaissance;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatistiqueServiceImpl implements StatistiqueService{

    private final JugeNaissanceActeRep jugeNaissanceActeRep;
    private final NaissanceActeRepository naissanceActeRepository;

    @Override
    public StatistiquePourcentageSexeActes graphes() {


        //////Partie Juge Naissance
        int nbrActeJugeNaissanceHomme=jugeNaissanceActeRep.findBySexFr("homme").size();
        int nbrActeJugeNaissanceFemme=jugeNaissanceActeRep.findBySexFr("femme").size();
        int nbrActeJugeNaissanceTotal=nbrActeJugeNaissanceFemme+nbrActeJugeNaissanceHomme;
        float pourcentageActeJugeNaissHomme=( (float) nbrActeJugeNaissanceHomme*100)/nbrActeJugeNaissanceTotal;
        float pourcentageActeJugeNaissFemme=( (float) nbrActeJugeNaissanceFemme*100)/nbrActeJugeNaissanceTotal;

        /////Partie Naissance
        int nbrActeNaissanceHomme=naissanceActeRepository.findBySexFr("homme").size();
        int nbrActeNaissanceFemme=naissanceActeRepository.findBySexFr("femme").size();
        int nbrActeNaissanceTotal=nbrActeNaissanceHomme+nbrActeNaissanceFemme;
        float pourcentageActeNaissHomme=( (float) nbrActeNaissanceHomme*100)/nbrActeNaissanceTotal;
        float pourcentageActeNaissFemme=( (float) nbrActeNaissanceFemme*100)/nbrActeNaissanceTotal;

        /////Partie Juge Dece
        int nbrJugeActeDeceHomme=0;
        int nbrJugeActeDeceFemme=0;
        int nbrActeJugeDeceTotal=0;
        float pourcentageActeJugeDeceHomme=((float)nbrJugeActeDeceHomme*100)/nbrActeJugeDeceTotal;
        float pourcentageActeJugeDeceFemme=((float)nbrJugeActeDeceFemme*100)/nbrActeJugeDeceTotal;

        /////Partie Dece
        int nbrActeDeceHomme=0;
        int nbrActeDeceFemme=0;
        int nbrActeDeceTotal=0;
        float pourcentageActeDeceHomme=((float)nbrActeDeceHomme*100)/nbrActeDeceTotal;
        float pourcentageActeDeceFemme=((float) nbrActeDeceFemme*100)/nbrActeDeceTotal;

        StatistiquePourcentageSexeActes pourcentageSexeActes=new StatistiquePourcentageSexeActes(
                pourcentageActeNaissHomme,
                pourcentageActeNaissFemme,
                pourcentageActeJugeNaissHomme,
                pourcentageActeJugeNaissFemme,
                pourcentageActeDeceHomme,
                pourcentageActeDeceFemme,
                pourcentageActeJugeDeceHomme,
                pourcentageActeJugeDeceFemme
        );

        return pourcentageSexeActes;
    }

    @Override
    public StatistiqueNbrActesSexe resume(int mois, int annee) {
        System.out.println("mois "+mois+" anne "+annee);


        //////Partie Naissance
        int nbrActeNaissanceHomme=0;
        int nbrActeNaissanceFemme=0;
        List<ActeNaissance> acteNaissance=naissanceActeRepository.findByAnnee(annee);
        for(ActeNaissance acteNaissance1:acteNaissance)
            {
                String[] date=acteNaissance1.getDateNaissance().toString().split("-");

                nbrActeNaissanceHomme=nbrActeNaissanceHomme+(Integer.parseInt(date[1])==mois?(acteNaissance1.getSexFr().equals("homme")?1:0):0);
                nbrActeNaissanceFemme=nbrActeNaissanceFemme+(Integer.parseInt(date[1])==mois?(acteNaissance1.getSexFr().equals("femme")?1:0):0);

            }

        //////Partie Juge Naissance
        int nbrActeJugeNaissanceHomme=0;
        int nbrActeJugeNaissanceFemme=0;
        List<ActeJugeNaissancee> acteJugeNaissancees=jugeNaissanceActeRep.findByAnnee(annee);
        for(ActeJugeNaissancee acteJugeNaissancee:acteJugeNaissancees)
            {
                String[] date=acteJugeNaissancee.getDateNaissance().toString().split("-");

                nbrActeJugeNaissanceHomme=nbrActeJugeNaissanceHomme+(Integer.parseInt(date[1])==mois?(acteJugeNaissancee.getSexFr().equals("homme")?1:0):0);
                nbrActeJugeNaissanceFemme=nbrActeJugeNaissanceFemme+(Integer.parseInt(date[1])==mois?(acteJugeNaissancee.getSexFr().equals("femme")?1:0):0);

            }
        /////Partie Dece
        int nbrActeDeceHomme=0;
        int nbrActeDeceFemme=0;

        /////Partie Juge Dece
        int nbrJugeActeDeceHomme=0;
        int nbrJugeActeDeceFemme=0;


        StatistiqueNbrActesSexe statistiqueNbrActesSexe=new StatistiqueNbrActesSexe(
                nbrActeNaissanceHomme,
                nbrActeNaissanceFemme,
                nbrActeNaissanceHomme+nbrActeNaissanceFemme,
                nbrActeJugeNaissanceHomme,
                nbrActeJugeNaissanceFemme,
                nbrActeJugeNaissanceFemme+nbrActeJugeNaissanceHomme,
                nbrActeDeceHomme,
                nbrActeDeceFemme,
                nbrActeDeceHomme+nbrActeDeceFemme,
                nbrJugeActeDeceHomme,
                nbrJugeActeDeceFemme,
                nbrJugeActeDeceHomme+nbrJugeActeDeceFemme,
                "أرسلت إلى القسم الإقليمي . بعد إثبات مطابقتها لسجل الحالة المدنية"
                );

        return statistiqueNbrActesSexe;

    }

    @Override
    public List<StatistiqueAdulte> adulte(int ans, int annee) {
        List<StatistiqueAdulte> statistiquesAdulte=new ArrayList<>();

        //////Partie Naissance
        List<ActeNaissance> acteNaissance=naissanceActeRepository.findByAnnee(annee-ans);
        for(ActeNaissance acteNaissance1:acteNaissance)
            {
                StatistiqueAdulte resultatsmall=new StatistiqueAdulte(acteNaissance1.getNumeroActe(), acteNaissance1.getNomAr(), acteNaissance1.getPrenomAr(), acteNaissance1.getDateNaissance().toString(), acteNaissance1.getDateEdition().toString(),ans, annee);
                statistiquesAdulte.add(resultatsmall);
            }

        /////Partie Juge naissance
        List<ActeJugeNaissancee> acteJugeNaissancees=jugeNaissanceActeRep.findByAnnee(annee-ans);
        for(ActeJugeNaissancee acteJugeNaissancee:acteJugeNaissancees)
        {
            log.info(acteJugeNaissancee.getPrenomAr());
            StatistiqueAdulte resultatsmall=new StatistiqueAdulte(acteJugeNaissancee.getNumeroActe(), acteJugeNaissancee.getNomAr(), acteJugeNaissancee.getPrenomAr(), acteJugeNaissancee.getDateNaissance(), acteJugeNaissancee.getDateEdition(),ans, annee);
            statistiquesAdulte.add(resultatsmall);
        }

        return statistiquesAdulte;
    }


}
