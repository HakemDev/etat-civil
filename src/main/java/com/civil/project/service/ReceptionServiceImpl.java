package com.civil.project.service;

import com.civil.project.dao.JugeNaissanceActeRep;
import com.civil.project.dao.NaissanceActeRep_user2;
import com.civil.project.dto.Reception;
import com.civil.project.rest.RéceptionRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceptionServiceImpl implements ReceptionService{
    private final JugeNaissanceActeRep jugeNaissanceActeRep;
    private final NaissanceActeRep_user2 naissanceActeRepUser2;
    @Override
    public Reception PourcentagActeGlobal() {
        int NbrActeJugeNaissance=(int) jugeNaissanceActeRep.findAll().size();
        int NbrActeNaissance=(int) naissanceActeRepUser2.findAll().size();
        int NbrActeDeces=0;
        int NbreActeJugeDeces=0;

        int NbrTotal=NbrActeDeces+NbreActeJugeDeces+NbrActeNaissance+NbrActeJugeNaissance;

        float PourcentageActeNaissance=(NbrActeNaissance*100)/NbrTotal;
        float PourcentageActeJugeNaissance=(NbrActeJugeNaissance*100)/NbrTotal;
        float PourcentageActeDeces=(NbrActeDeces*100)/NbrTotal;
        float PourcentageActeJugeDeces=(NbreActeJugeDeces*100)/NbrTotal;

        Reception pourcentageActes=new Reception();

        pourcentageActes.setPourcentageActedejugeNaissance(PourcentageActeJugeNaissance);
        pourcentageActes.setPourcentageActeDeNaissance(PourcentageActeNaissance);
        pourcentageActes.setPourcentageActeDeces(PourcentageActeDeces);
        pourcentageActes.setPourcentageActeJugeDeces(PourcentageActeJugeDeces);

        return pourcentageActes;
    }

    @Override
    public Reception NombregActeGlobal() {
        int NbrActeJugeNaissance=(int) jugeNaissanceActeRep.findAll().size();
        int NbrActeNaissance=(int) naissanceActeRepUser2.findAll().size();

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
            int NbrActeJugeNaissance=(int) jugeNaissanceActeRep.findByAnnee(anne-i).size();
            int NbrActeNaissance=(int) naissanceActeRepUser2.findByAnnee(anne-i).size();

            Reception reception=new Reception();
            reception.setNbrActedejugeNaissance(NbrActeJugeNaissance);
            reception.setNbrActeDeNaissance(NbrActeNaissance);

            receptions.add(reception);
        }
        return receptions;
    }
}
