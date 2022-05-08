package com.civil.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatistiqueAdulte {

    private int numeroActe;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String dateEdition;

    private int anne;
    private int ans;


}
