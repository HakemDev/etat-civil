package com.civil.project.service;

import com.civil.project.dao.JugeNaissanceActeRep;
import com.civil.project.dao.NaissanceActeRepository;
import com.civil.project.dto.Reception;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceptionServiceImpl implements ReceptionService{
    private final JugeNaissanceActeRep jugeNaissanceActeRep;
    private final NaissanceActeRepository naissanceActeRepUser2;
    @Override
    public Reception PourcentagActeGlobal() {
        int NbrActeJugeNaissance= jugeNaissanceActeRep.findAll().size();
        int NbrActeNaissance=naissanceActeRepUser2.findAll().size();
        int NbrActeDeces=0;
        int NbreActeJugeDeces=0;

        int NbrTotal=NbrActeDeces+NbreActeJugeDeces+NbrActeNaissance+NbrActeJugeNaissance;

        float PourcentageActeNaissance= ((float)NbrActeNaissance*100)/NbrTotal;
        float PourcentageActeJugeNaissance=((float) NbrActeJugeNaissance*100)/NbrTotal;
        float PourcentageActeDeces=( (float) NbrActeDeces*100)/NbrTotal;
        float PourcentageActeJugeDeces=( (float) NbreActeJugeDeces*100)/NbrTotal;

        Reception pourcentageActes=new Reception();

        pourcentageActes.setPourcentageActedejugeNaissance(PourcentageActeJugeNaissance);
        pourcentageActes.setPourcentageActeDeNaissance(PourcentageActeNaissance);
        pourcentageActes.setPourcentageActeDeces(PourcentageActeDeces);
        pourcentageActes.setPourcentageActeJugeDeces(PourcentageActeJugeDeces);

        return pourcentageActes;
    }

    @Override
    public Reception NombregActeGlobal() {
        int NbrActeJugeNaissance=jugeNaissanceActeRep.findAll().size();
        int NbrActeNaissance= naissanceActeRepUser2.findAll().size();

        Reception nbrActes=new Reception();

        nbrActes.setNbrActedejugeNaissance(NbrActeJugeNaissance);
        nbrActes.setNbrActeDeNaissance(NbrActeNaissance);
        /*
        nbrActes.setNbrActeDeces(1);
        nbrActes.setNbrActeJugeDeces(1);
         */

        return nbrActes;
    }

    @Override
    public List<Reception> NombreActeAnnee(){
        int anne=2022;
        List<Reception> receptions=new ArrayList<>();
        for(int i=0;i<5;i++){
            int NbrActeJugeNaissance=jugeNaissanceActeRep.findByAnnee(anne-i).size();
            int NbrActeNaissance=naissanceActeRepUser2.findByAnnee(anne-i).size();

            Reception reception=new Reception();
            reception.setNbrActedejugeNaissance(NbrActeJugeNaissance);
            reception.setNbrActeDeNaissance(NbrActeNaissance);

            receptions.add(reception);
        }
        return receptions;
    }
}
