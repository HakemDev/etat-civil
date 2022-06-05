package com.civil.project.service;

import com.civil.project.jugesNaissances.dao.JugeNaissanceActeRep;
import com.civil.project.naissances.dao.NaissanceActeRepository;
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
    public Reception NombregActePourcentageGlobal() {


        Reception reception=new Reception();

        //partie: nombre actes
        int NbrActeJugeNaissance= jugeNaissanceActeRep.findAll().size();
        int NbrActeNaissance=naissanceActeRepUser2.findAll().size();
        int NbrActeDeces=0;
        int NbreActeJugeDeces=0;

        //partie: pourcentage actes
        int NbrTotal=NbrActeDeces+NbreActeJugeDeces+NbrActeNaissance+NbrActeJugeNaissance;

        float PourcentageActeNaissance= ((float)NbrActeNaissance*100)/NbrTotal;
        float PourcentageActeJugeNaissance=((float) NbrActeJugeNaissance*100)/NbrTotal;
        float PourcentageActeDeces=( (float) NbrActeDeces*100)/NbrTotal;
        float PourcentageActeJugeDeces=( (float) NbreActeJugeDeces*100)/NbrTotal;

        //Partie: insertion de resultat
        reception.setPourcentageActedejugeNaissance(PourcentageActeJugeNaissance);
        reception.setPourcentageActeDeNaissance(PourcentageActeNaissance);
        reception.setPourcentageActeDeces(PourcentageActeDeces);
        reception.setPourcentageActeJugeDeces(PourcentageActeJugeDeces);

        reception.setNbrActeDeNaissance(NbrActeNaissance);
        reception.setNbrActedejugeNaissance(NbrActeJugeNaissance);
        reception.setNbrActeDeces(NbrActeDeces);
        reception.setNbrActeJugeDeces(NbreActeJugeDeces);
        return reception;
    }

    @Override
    public List<Reception> NombreActeAnnee(int anne){

        List<Reception> receptions=new ArrayList<>();
        for(int i=0;i<5;i++){
            int NbrActeJugeNaissance=jugeNaissanceActeRep.findByAnnee(anne-i).size();
            int NbrActeNaissance=naissanceActeRepUser2.findByAnnee(anne-i).size();

            Reception reception=new Reception();
            reception.setNbrActedejugeNaissance(NbrActeJugeNaissance);
            reception.setNbrActeDeNaissance(NbrActeNaissance);
            reception.setAnnee(anne-i);
            receptions.add(reception);
        }
        return receptions;
    }
}
