package com.civil.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatistiquePourcentageSexeActes {

    private float acteNaissanceHomme ;
    private float acteNaissanceFemme ;
    private float acteJugeNaissanceHomme ;
    private float acteJugeNaissanceFemme ;
    private float acteDeceHomme ;
    private float acteDeceFemme ;
    private float acteJugeDeceHomme ;
    private float acteJugeDeceFemme ;

}
