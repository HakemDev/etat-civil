package com.civil.project.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
public class Commune {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_commune")
    private int idCommune;
    
    @Column(name = "nom_commune_ar")
    private String nomCommuneAr;
    
    @Column(name = "nom_commune_fr")
    private String nomCommuneFr;
    
    @Column(name = "region_fr")
    private String regionFr;
    
    @Column(name = "region_ar")
    private String regionAr;
    
    @Column(name = "ville_fr")
    private String villeFr;
    
    @Column(name = "ville_ar")
    private String villeAr;


}
