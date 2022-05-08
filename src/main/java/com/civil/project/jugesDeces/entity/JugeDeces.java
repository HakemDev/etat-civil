package com.civil.project.jugesDeces.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "juge_deces")
@Data
public class JugeDeces {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iddeces")
    private int iddeces;

    @Column(name = "adresse_parent_ar")
    private String adresseParentAr;

    @Column(name = "adresse_parent_fr")
    private String adresseParentFr;

    @Column(name = "cin")
    private String cin;

    @Column(name = "heure_deces")
    private String heureDeces;

    @Column(name = "date_naissance")
    private Date dateNaissance;

    // date naissance
    @Column(name = "date_gregorienne_txt_ar")
    private String dateGregorienneTxtAr;

    @Column(name = "date_gregorienne_txt_fr")
    private String dateGregorienneTxtFr;

    @Column(name = "date_hijri_txt_ar")
    private String dateHijriTxtAr;

    @Column(name = "date_hijri_txt_fr")
    private String dateHijriTxtFr;

    @Column(name = "declaration_ar")
    private String declarationAr;

    @Column(name = "declaration_fr")
    private String declarationFr;

    @Column(name = "date_edition")
    private Date dateEdition;

    @Column(name = "date_deces")
    private Date dateDeces;

    @Column
    private String dateDecesGregorienneTxtAr;

    @Column
    private String dateDecesGregorienneTxtFr;

    @Column
    private String dateDecesHijriTxtAr;

    @Column
    private String dateDecesHijriTxtFr;

    @Column(name = "prenom_ar")
    private String prenomAr;

    @Column(name = "prenom_fr")
    private String prenomFr;

    @Column(name = "nom_ar")
    private String nomAr;

    @Column(name = "nom_fr")
    private String nomFr;

    @Column(name = "prenom_pere_ar")
    private String prenomPereAr;

    @Column(name = "prenom_pere_fr")
    private String prenomPereFr;

    @Column(name = "nationalite_pere_ar")
    private String nationalitePereAr;

    @Column(name = "nationalite_pere_fr")
    private String nationalitePereFr;

    @Column(name = "profession_pere_ar")
    private String professionPereAr;

    @Column(name = "profession_pere_fr")
    private String professionPereFr;

    @Column(name = "prenom_mere_ar")
    private String prenomMereAr;

    @Column(name = "prenom_mere_fr")
    private String prenomMereFr;


    @Column(name = "nationalite_mere_ar")
    private String nationaliteMereAr;

    @Column(name = "nationalite_mere_fr")
    private String nationaliteMereFr;

    @Column(name = "profession_mere_ar")
    private String professionMereAr;

    @Column(name = "profession_mere_fr")
    private String professionMereFr;

    @Column(name = "lieu_deces_ar")
    private String lieuDecesAr;

    @Column(name = "lieu_deces_fr")
    private String lieuDecesFr;

    @Column(name = "lieu_naissance_ar")
    private String lieuNaissanceAr;

    @Column(name = "lieu_naissance_fr")
    private String lieuNaissanceFr;

    @Column(name = "profession_ar")
    private String professionAr;

    @Column(name = "profession_fr")
    private String professionFr;

    @Column(name = "num_deces")
    private int numJugeDeces;

    @Column(name = "residence_ar")
    private String residenceAr;

    @Column(name = "residence_fr")
    private String residenceFr;

    @Column(name = "sexe_ar")
    private String sexeAr;

    @Column(name = "sexe_fr")
    private String sexeFr;


    @Column(name = "statut_ar")
    private String statutAr;

    @Column(name = "statut_fr")
    private String statutFr;

    @Column(name = "situation_familiale_ar")
    private String situationFamilialeAr;

    @Column(name = "situation_familiale_fr")
    private String situationFamilialeFr;

    @Column(name = "epoux_ar")
    private String epouxAr;

    @Column(name = "epoux_fr")
    private String epouxFr;

    @Column(name = "officier_ar")
    private String officierAr;

    @Column(name = "officier_fr")
    private String officierFr;

    @Column
    private String jugeAr;

    @Column
    private String jugeFr;

    @Column
    private String ikhbarAr;

    @Column
    private String ikhbarFr;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,
            CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "id_registre_juges_deces")
    RegistreJugesDeces registreJugesDeces;

}
