package com.civil.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatistiqueNbrActesSexe {

    private int nbracteNaissanceHomme ;
    private int nbracteNaissanceFemme ;
    private int nbrTotalActeNaissance;

    private int nbracteJugeNaissanceHomme ;
    private int nbracteJugeNaissanceFemme ;
    private int nbrTotalActeJugeNaissance;

    private int nbracteDeceHomme ;
    private int nbracteDeceFemme ;
    private int nbrTotalActeDece;

    private int nbracteJugeDeceHomme ;
    private int nbracteJugeDeceFemme ;
    private int nbrTotalActeJugeDece;

    private String remarque;
}
