package com.civil.project.jugesNaissances.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="acte_juge_naissance")
@Data
@ToString
public class ActeJugeNaissancee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_juge_naissance")
    private int idNaissance;

    @Column(name = "numero_acte")
    private int numeroActe;

    @Column(name = "nom_ar")
    private String nomAr;

    @Column(name = "prenom_ar")
    private String prenomAr;

    @Column(name = "nom_fr")
    private String nomFr;

    @Column(name = "prenom_fr")
    private String prenomFr;

    @Column(name = "classement")
    private int classement;

    @Column(name = "annee")
    private Integer annee;


    @Column(name = "heure_naissance")
    private String heureNaissance;

    @Column(name = "declaration_txt_ar")
    private String declarationTxtAr;

    @Column(name = "declaration_txt_fr")
    private String declarationTxtFr;

    @Column(name = "date_naissance")
    private String dateNaissance;

    @Column(name = "lieu_naissance_ar")
    private String lieuNaissanceAr;

    @Column(name = "lieu_naissance_fr")
    private String lieuNaissanceFr;

    @Column(name = "date_gregorienne_txt_ar")
    private String dateGregorienneTxtAr;

    @Column(name = "date_gregorienne_txt_fr")
    private String dateGregorienneTxtFr;

    @Column(name = "date_hijri_txt_ar")
    private String dateHijriTxtAr;

    @Column(name = "date_hijri_txt_fr")
    private String dateHijriTxtFr;

    @Column(name = "sex_ar")
    private String sexAr;

    @Column(name = "sex_fr")
    private String sexFr;

    @Column(name = "prenom_pere_ar")
    private String prenomPereAr;

    @Column(name = "prenom_pere_fr")
    private String prenomPereFr;

    @Column(name = "lieu_naissance_pere_ar")
    private String lieuNaissancePereAr;

    @Column(name = "lieu_naissance_pere_fr")
    private String lieuNaissancePereFr;

    @Column(name = "nationalite_pere_ar")
    private String nationalitePereAr;

    @Column(name = "nationalite_pere_fr")
    private String nationalitePereFr;

    @Column(name = "profession_pere_fr")
    private String professionPereFr;

    @Column(name = "profession_pere_ar")
    private String professionPereAr;

    @Column(name = "date_naissance_pere")
    private String dateNaissancePere;

    @Column(name = "date_gregorienne_pere_txt_ar")
    private String dateGregoriennePereTxtAr;

    @Column(name = "date_gregorienne_pere_txt_fr")
    private String dateGregoriennePereTxtFr;

    @Column(name = "date_hijri_pere_txt_ar")
    private String dateHijriPereTxtAr;

    @Column(name = "date_hijri_pere_txt_fr")
    private String dateHijriPereTxtFr;

    @Column(name = "nom_pere_pere_fr")
    private String nomPerePereFr;

    @Column(name = "nom_pere_pere_ar")
    private String nomPerePereAr;

    @Column(name = "annee_naissance_pere")
    private int anneeNaissancePere;


    @Column(name = "prenom_mere_ar")
    private String prenomMereAr;

    @Column(name = "prenom_mere_fr")
    private String prenomMereFr;

    @Column(name = "annee_naissance_mere")
    private int anneeNaissanceMere;

    @Column(name = "lieu_naissance_mere_ar")
    private String lieuNaissanceMereAr;

    @Column(name = "lieu_naissance_mere_fr")
    private String lieuNaissanceMereFr;

    @Column(name = "profession_mere_ar")
    private String professionMereAr;

    @Column(name = "profession_mere_fr")
    private String professionMereFr;

    @Column(name = "nationalite_mere_ar")
    private String nationaliteMereAr;

    @Column(name = "nationalite_mere_fr")
    private String nationaliteMereFr;

    @Column(name = "date_hijri_mere_txt_fr")
    private String dateHijriMereTxtFr;

    @Column(name = "date_naissance_mere")
    private String dateNaissanceMere;

    @Column(name = "date_gregorienne_mere_txt_ar")
    private String dateGregorienneMereTxtAr;

    @Column(name = "date_gregorienne_mere_txt_fr")
    private String dateGregorienneMereTxtFr;

    @Column(name = "date_hijri_mere_txt_ar")
    private String dateHijriMereTxtAr;

    @Column(name = "nom_pere_mere_ar")
    private String nomPereMereAr;

    @Column(name = "nom_pere_mere_fr")
    private String nomPereMereFr;

    @Column(name = "adresse_ar")
    private String adresseAr;

    @Column(name = "province_ar")
    private String provinceAr;

    @Column(name = "province_fr")
    private String provinceFr;

    @Column(name = "adresse_fr")
    private String adresseFr;

    @Column(name = "type_declaration_ar")
    private String typeDeclarationAr;

    @Column(name = "date_edition")
    private String dateEdition;

    @Column(name = "officier_ar")
    private String officierAr;

    @Column(name = "officier_fr")
    private String officierFr;

    @Column(name = "type_declaration_fr")
    private String typeDeclarationFr;

    @Column(name="mere_defunte")
    private boolean mereDefunte;

    @Column(name="pere_defunt")
    private boolean pereDefunt;

    @Column(name="jumeaux")
    private boolean jumeaux;

    @Column(name="acte_ar")
    private String acteAr;

    @Column(name="acte_fr")
    private String acteFr;

    @Column(name = "date_juge")
    private String dateJuge;

    @Column
    private String ikhbar;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.PERSIST,
            CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "id_registre")
    private RegistreJugeNaiss registreJugeNaiss;


    @JsonIgnore
    @OneToMany(mappedBy = "acteNaissance",cascade = CascadeType.REMOVE )
    private List<MargJugeNaissAr> margJugeNaissArs;

    @JsonIgnore
    @OneToMany(mappedBy = "acteNaissance",cascade = CascadeType.REMOVE )
    private List<MargJugeNaissFr> margJugeNaissFrs;



}
