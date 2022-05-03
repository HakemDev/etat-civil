package com.civil.project.service;

import com.civil.project.dao.JugeNaissanceActeRep;
import com.civil.project.dao.NaissanceActeRep_user2;
import com.civil.project.dto.Reception;
import com.civil.project.rest.RéceptionRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceptionServiceImpl implements ReceptionService{
    private final JugeNaissanceActeRep jugeNaissanceActeRep;
    private final NaissanceActeRep_user2 naissanceActeRepUser2;
    @Override
    public Reception PourcentagActeGlobal() {
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
}
