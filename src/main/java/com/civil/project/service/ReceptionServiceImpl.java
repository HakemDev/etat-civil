package com.civil.project.service;

import com.civil.project.deces.dao.DecesActeRep;
import com.civil.project.deces.entity.ActeDeces;
import com.civil.project.jugesDeces.dao.JugeDecesRepository;
import com.civil.project.jugesDeces.entity.JugeDeces;
import com.civil.project.jugesNaissances.dao.JugeNaissanceActeRep;
import com.civil.project.naissances.dao.NaissanceActeRepository;
import com.civil.project.dto.Reception;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReceptionServiceImpl implements ReceptionService{
    private final JugeNaissanceActeRep jugeNaissanceActeRep;
    private final NaissanceActeRepository naissanceActeRepUser2;
    private final DecesActeRep decesActeRep;
    private final JugeDecesRepository jugeDecesRepository;
    @Override
    public Reception PourcentagActeGlobal() {
        int NbrActeJugeNaissance= jugeNaissanceActeRep.findAll().size();
        int NbrActeNaissance=naissanceActeRepUser2.findAll().size();
        int NbrActeDeces=decesActeRep.findAll().size();
        int NbreActeJugeDeces=jugeDecesRepository.findAll().size();

        int NbrTotal=NbrActeDeces+NbreActeJugeDeces+NbrActeNaissance+NbrActeJugeNaissance;

        float PourcentageActeNaissance= ((float)NbrActeNaissance*100)/NbrTotal;
        float PourcentageActeJugeNaissance=((float) NbrActeJugeNaissance*100)/NbrTotal;
        float PourcentageActeDeces=( (float) NbrActeDeces*100)/NbrTotal;
        float PourcentageActeJugeDeces=( (float) NbreActeJugeDeces*100)/NbrTotal;

        Reception pourcentageActes=new Reception(0,0,0,0,PourcentageActeNaissance,PourcentageActeJugeNaissance,PourcentageActeDeces,PourcentageActeJugeDeces,0);
        return pourcentageActes;
    }

    @Override
    public Reception NombregActePourcentageGlobal() {




        //partie: nombre actes
        int NbrActeJugeNaissance= jugeNaissanceActeRep.findAll().size();
        int NbrActeNaissance=naissanceActeRepUser2.findAll().size();
        int NbrActeDeces=decesActeRep.findAll().size();
        int NbreActeJugeDeces=jugeDecesRepository.findAll().size();

        //partie: pourcentage actes
        int NbrTotal=NbrActeDeces+NbreActeJugeDeces+NbrActeNaissance+NbrActeJugeNaissance;

        float PourcentageActeNaissance= ((float)NbrActeNaissance*100)/NbrTotal;
        float PourcentageActeJugeNaissance=((float) NbrActeJugeNaissance*100)/NbrTotal;
        float PourcentageActeDeces=( (float) NbrActeDeces*100)/NbrTotal;
        float PourcentageActeJugeDeces=( (float) NbreActeJugeDeces*100)/NbrTotal;

        //Partie: insertion de resultat
        Reception reception=new Reception(NbrActeNaissance,NbrActeJugeNaissance,NbrActeDeces,
                NbreActeJugeDeces,
                PourcentageActeNaissance,
                PourcentageActeJugeNaissance,
                PourcentageActeDeces,
                PourcentageActeJugeDeces,
                0);
        return reception;
    }

    @Override
    public List<Reception> NombreActeAnnee(int anne){

        List<Reception> receptions=new ArrayList<>();
        List<ActeDeces> acteDeces=decesActeRep.findAll();
        List<JugeDeces> jugeDeces=jugeDecesRepository.findAll();
        for(int i=0;i<5;i++){
            int j=i;
            int NbrActeJugeNaissance=jugeNaissanceActeRep.findByAnnee(anne-i).size();
            int NbrActeNaissance=naissanceActeRepUser2.findByAnnee(anne-i).size();
            int NbrActeDeces=  acteDeces
                    .stream()
                    .filter(q->Integer.parseInt(q.getDateDeces().toString().split("-")[0])==anne-j)
                    .collect(Collectors.toList()).size();
            int NbrActeJugeDeces=  jugeDeces
                    .stream()
                    .filter(q->Integer.parseInt(q.getDateDeces().toString().split("-")[0])==anne-j)
                    .collect(Collectors.toList()).size();


            Reception reception=new Reception(
                    NbrActeNaissance
                    ,NbrActeJugeNaissance
                    ,NbrActeDeces
                    ,NbrActeJugeDeces
                    ,0
                    ,0
                    ,0
                    ,0
                    ,anne-i
            );
            receptions.add(reception);
        }
        return receptions;
    }
}
