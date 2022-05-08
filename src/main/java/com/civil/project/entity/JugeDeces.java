package com.civil.project.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "juge_deces")
@Data
public class JugeDeces {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iddeces")
    private int iddeces;

    @Column(name = "addresse_parent_ar")
    private String addresseParentAr;

    @Column(name = "addresse_parent_fr")
    private String addresseParentFr;

    @Column(name = "cin")
    private String cin;

    @Column(name = "heure")
    private String heure;

    @Column(name = "date_naissance")
    private Date dateNaissance;

    @Column(name = "declaration_ar")
    private String declarationAr;

    @Column(name = "declaration_fr")
    private String declarationFr;

    @Column(name = "date_edition_grego")
    private String dateEditionGrego;

    @Column(name = "date_edition_grego_txt_ar")
    private String dateEditionGregoTxtAr;

    @Column(name = "date_edition_grego_txt_fr")
    private String dateEditionGregoTxtFr;

    @Column(name = "date_deces_grego")
    private String dateDecesGrego;

    @Column(name = "date_deces_grego_txt_ar")
    private String dateDecesGregoTxtAr;

    @Column(name = "date_deces_grego_txt_fr")
    private String dateDecesGregoTxtFr;

    @Column(name = "date_edition_hijri")
    private String dateEditionHijri;

    @Column(name = "date_edition_hijri_txt_ar")
    private String dateEditionHijriTxtAr;

    @Column(name = "date_edition_hijri_txt_fr")
    private String dateEditionHijriTxtFr;

    @Column(name = "date_deces_hijri")
    private String dateDecesHijri;

    @Column(name = "date_deces_hijri_txt_ar")
    private String dateDecesHijriTxtAr;

    @Column(name = "date_deces_hijri_txt_fr")
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

    @Column(name = "nom_pere_ar")
    private String nomPereAr;

    @Column(name = "nom_pere_fr")
    private String nomPereFr;

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

    @Column(name = "nom_mere_ar")
    private String nomMereAr;

    @Column(name = "nom_mere_fr")
    private String nomMereFr;

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

    @Column(name = "addresse_ar")
    private String addresseAr;

    @Column(name = "addresse_fr")
    private String addresseFr;

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
    private String juge;

    @Column
    private String ikhbar;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,
            CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "id_registre_juges_deces")
    RegistreDeces registreDeces;

}
