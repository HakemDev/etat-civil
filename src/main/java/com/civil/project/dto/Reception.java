package com.civil.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reception {

    private int NbrActeDeNaissance;
    private int NbrActedejugeNaissance;
    private int NbrActeDeces;
    private int NbrActeJugeDeces;

    private float PourcentageActeDeNaissance;
    private float PourcentageActedejugeNaissance;
    private float PourcentageActeDeces;
    private float PourcentageActeJugeDeces;

}
