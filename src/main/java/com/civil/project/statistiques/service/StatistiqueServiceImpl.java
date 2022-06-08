package com.civil.project.statistiques.service;

import com.civil.project.deces.dao.DecesActeRep;
import com.civil.project.deces.entity.ActeDeces;
import com.civil.project.jugesDeces.dao.JugeDecesRepository;
import com.civil.project.jugesDeces.entity.JugeDeces;
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
import java.util.HashMap;
import java.util.List;
import java.text.DecimalFormat;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatistiqueServiceImpl implements StatistiqueService{

    private final JugeNaissanceActeRep jugeNaissanceActeRep;
    private final NaissanceActeRepository naissanceActeRepository;
    private final JugeDecesRepository jugeDecesRepository;
    private final DecesActeRep decesActeRep;

    //عدد الولادات و الوفيات و أحكام الولادات و أحكام الوفيات بالنسبة للدكور و الإناث
    @Override
    public StatistiquePourcentageSexeActes graphes() {

        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(2);

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
        int nbrJugeActeDeceHomme=jugeDecesRepository.findBySexeFr("homme").size();
        int nbrJugeActeDeceFemme=jugeDecesRepository.findBySexeFr("femme").size();
        int nbrActeJugeDeceTotal=nbrJugeActeDeceHomme+nbrJugeActeDeceFemme;
        float pourcentageActeJugeDeceHomme=((float)nbrJugeActeDeceHomme*100)/nbrActeJugeDeceTotal;
        float pourcentageActeJugeDeceFemme=((float)nbrJugeActeDeceFemme*100)/nbrActeJugeDeceTotal;

        /////Partie Dece
        int nbrActeDeceHomme=decesActeRep.findBySexeFr("homme").size();
        int nbrActeDeceFemme=decesActeRep.findBySexeFr("femme").size();
        int nbrActeDeceTotal=nbrActeDeceHomme+nbrActeDeceFemme;
        float pourcentageActeDeceHomme=((float)nbrActeDeceHomme*100)/nbrActeDeceTotal;
        float pourcentageActeDeceFemme=((float) nbrActeDeceFemme*100)/nbrActeDeceTotal;

        StatistiquePourcentageSexeActes pourcentageSexeActes=new StatistiquePourcentageSexeActes(
                Math.round(pourcentageActeNaissHomme),
                Math.round(pourcentageActeNaissFemme) ,
                Math.round(pourcentageActeJugeNaissHomme) ,
                Math.round(pourcentageActeJugeNaissFemme) ,
                Math.round(pourcentageActeDeceHomme) ,
                Math.round(pourcentageActeDeceFemme) ,
                Math.round(pourcentageActeJugeDeceHomme) ,
                Math.round(pourcentageActeJugeDeceFemme)
        );

        return pourcentageSexeActes;
    }

    //ملخص الإحصائيات
    @Override
    public StatistiqueNbrActesSexe resume(int mois, int annee) {
        //System.out.println("mois "+mois+" anne "+annee);


        //////Partie Naissance
        int nbrActeNaissanceHomme=0;
        int nbrActeNaissanceFemme=0;
        List<ActeNaissance> acteNaissance=naissanceActeRepository.findByAnnee(annee);
        if(!acteNaissance.isEmpty()) {
            for (ActeNaissance acteNaissance1 : acteNaissance) {
                String[] date = acteNaissance1.getDateNaissance().toString().split("-");

                nbrActeNaissanceHomme = nbrActeNaissanceHomme + (Integer.parseInt(date[1]) == mois ? (acteNaissance1.getSexFr().equals("homme") ? 1 : 0) : 0);
                nbrActeNaissanceFemme = nbrActeNaissanceFemme + (Integer.parseInt(date[1]) == mois ? (acteNaissance1.getSexFr().equals("femme") ? 1 : 0) : 0);

            }
        }

        //////Partie Juge Naissance
        int nbrActeJugeNaissanceHomme=0;
        int nbrActeJugeNaissanceFemme=0;
        List<ActeJugeNaissancee> acteJugeNaissancees=jugeNaissanceActeRep.findByAnnee(annee);
        if(!acteJugeNaissancees.isEmpty())
        {
            for(ActeJugeNaissancee acteJugeNaissancee:acteJugeNaissancees)
                {
                    String[] date=acteJugeNaissancee.getDateNaissance().toString().split("-");

                    nbrActeJugeNaissanceHomme=nbrActeJugeNaissanceHomme+(Integer.parseInt(date[1])==mois?(acteJugeNaissancee.getSexFr().equals("homme")?1:0):0);
                    nbrActeJugeNaissanceFemme=nbrActeJugeNaissanceFemme+(Integer.parseInt(date[1])==mois?(acteJugeNaissancee.getSexFr().equals("femme")?1:0):0);

                }
        }
        /////Partie Dece
        int nbrActeDeceHomme=0;
        int nbrActeDeceFemme=0;
        List<ActeDeces> acteDeces=decesActeRep.findAll();

        List<ActeDeces> acteDecesList=  acteDeces
                                        .stream()
                                        .filter(q->Integer.parseInt(q.getDateDeces().toString().split("-")[0])==annee)
                                        .collect(Collectors.toList());
        for(ActeDeces acteDeces1:acteDecesList)
            {
                String[] date=acteDeces1.getDateDeces().toString().split("-");
                nbrActeDeceHomme=nbrActeDeceHomme+(Integer.parseInt(date[1])==mois?(acteDeces1.getSexeFr().equals("homme")?1:0):0);
                nbrActeDeceFemme=nbrActeDeceFemme+(Integer.parseInt(date[1])==mois?(acteDeces1.getSexeFr().equals("femme")?1:0):0);
            }


        /////Partie Juge Dece
        int nbrJugeActeDeceHomme=0;
        int nbrJugeActeDeceFemme=0;

        List<JugeDeces> jugeDecesRepositoryList=jugeDecesRepository.findAll();

        List<JugeDeces> jugeDecesRepositories=  jugeDecesRepositoryList
                .stream()
                .filter(q->Integer.parseInt(q.getDateDeces().toString().split("-")[0])==annee)
                .collect(Collectors.toList());
        log.info("nbr "+jugeDecesRepositories.size());
        for(JugeDeces jugeDeces:jugeDecesRepositories)
        {
            String[] date=jugeDeces.getDateDeces().toString().split("-");
            nbrJugeActeDeceHomme=nbrJugeActeDeceHomme+(Integer.parseInt(date[1])==mois?(jugeDeces.getSexeFr().equals("homme")?1:0):0);
            nbrJugeActeDeceFemme=nbrJugeActeDeceFemme+(Integer.parseInt(date[1])==mois?(jugeDeces.getSexeFr().equals("femme")?1:0):0);
        }

        //Resultat
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

    //الأطفال البالغين
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
/*
    private final JugeNaissanceActeRep jugeNaissanceActeRep;
    private final NaissanceActeRepository naissanceActeRepository;
    private final JugeDecesRepository jugeDecesRepository;
    private final DecesActeRep decesActeRep;
 */
    //الجدول السنوي
    @Override
    public List<StatistiqueAdulte> annuel(String choix, int annee) {
        List<StatistiqueAdulte> statistiqueAdultes=new ArrayList<>();
        switch (choix)
            {
                case "naissance":
                    List<ActeNaissance> acteNaissances=naissanceActeRepository.findByAnnee(annee);
                    for(ActeNaissance acteNaissance:acteNaissances)
                        {
                            StatistiqueAdulte statistiqueAdulte=new StatistiqueAdulte(
                                    acteNaissance.getNumeroActe(),
                                    acteNaissance.getNomAr(),
                                    acteNaissance.getPrenomAr(),
                                    acteNaissance.getDateNaissance().toString(),
                                    acteNaissance.getDateEdition().toString(),
                                    annee,
                                    0
                            );
                            statistiqueAdultes.add(statistiqueAdulte);
                        }
                    break;
                case "jugeNaissance":
                    List<ActeJugeNaissancee> acteJugeNaissancees=jugeNaissanceActeRep.findByAnnee(annee);
                    for(ActeJugeNaissancee acteJugeNaissancee:acteJugeNaissancees)
                        {
                            StatistiqueAdulte statistiqueAdulte=new StatistiqueAdulte(
                                    acteJugeNaissancee.getNumeroActe(),
                                    acteJugeNaissancee.getNomAr(),
                                    acteJugeNaissancee.getPrenomAr(),
                                    acteJugeNaissancee.getDateNaissance(),
                                    acteJugeNaissancee.getDateEdition(),
                                    annee,
                                    0
                            );
                            statistiqueAdultes.add(statistiqueAdulte);
                        }
                    break;
                case "deces":
                    List<ActeDeces> acteDeces=decesActeRep.findAll();
                    List<ActeDeces> acteDecesList=  acteDeces
                            .stream()
                            .filter(q->Integer.parseInt(q.getDateDeces().toString().split("-")[0])==annee)
                            .collect(Collectors.toList());
                    for(ActeDeces acteDeces1:acteDecesList)
                        {
                            StatistiqueAdulte statistiqueAdulte=new StatistiqueAdulte(
                                    acteDeces1.getNumDeces(),
                                    acteDeces1.getNomAr(),
                                    acteDeces1.getPrenomAr(),
                                    acteDeces1.getDateDeces().toString(),
                                    acteDeces1.getDateEdition().toString(),
                                    annee,
                                    0
                              );
                            statistiqueAdultes.add(statistiqueAdulte);
                        }
                    break;
                case "jugeDeces":
                    List<JugeDeces> jugeDeces=jugeDecesRepository.findAll();
                    List<JugeDeces> jugeDecesList=jugeDeces
                                    .stream()
                                    .filter(q->Integer.parseInt(q.getDateDeces().toString().split("-")[0])==annee)
                                    .collect(Collectors.toList());
                    for(JugeDeces jugeDeces1:jugeDecesList)
                        {
                            StatistiqueAdulte statistiqueAdulte=new StatistiqueAdulte(
                                    jugeDeces1.getNumJugeDeces(),
                                    jugeDeces1.getNomAr(),
                                    jugeDeces1.getPrenomAr(),
                                    jugeDeces1.getDateDeces().toString(),
                                    jugeDeces1.getDateEdition().toString(),
                                    annee,
                                    0
                            );
                            statistiqueAdultes.add(statistiqueAdulte);
                        }
                    break;
            }

        return statistiqueAdultes;
    }


}
