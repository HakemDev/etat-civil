package com.civil.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utilisateur")
@JsonIgnoreProperties
@JsonIgnoreType
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private int id;

    @Column(name="nom_ar")
    private String nom_ar;

    @Column(name="nom_fr")
    private String nom_fr;

    @Column(name="prenom_ar")
    private String prenom_ar;

    @Column(name="prenom_fr")
    private String prenom_fr;

    @Column(name="role")
    private String role;

    @Column(name="mot_de_passe")
    private String mot_de_passe;

    @Column(name="login")
    private String login;

    @Column(name="id_commune")
    private int id_commune;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,CascadeType.PERSIST,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="id_utilisateur")
    private List<RegistreNaiss> registres;

    public String getNom_ar() {
        return nom_ar;
    }

    public void setNom_ar(String nom_ar) {
        this.nom_ar = nom_ar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_fr() {
        return nom_fr;
    }

    public void setNom_fr(String nom_fr) {
        this.nom_fr = nom_fr;
    }

    public String getPrenom_ar() {
        return prenom_ar;
    }

    public void setPrenom_ar(String prenom_ar) {
        this.prenom_ar = prenom_ar;
    }

    public String getPrenom_fr() {
        return prenom_fr;
    }

    public void setPrenom_fr(String prenom_fr) {
        this.prenom_fr = prenom_fr;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId_commune() {
        return id_commune;
    }

    public void setId_commune(int id_commune) {
        this.id_commune = id_commune;
    }

    public List<RegistreNaiss> getRegistres() {
        return registres;
    }

    public void setRegistres(List<RegistreNaiss> registres) {
        this.registres = registres;
    }

    public Utilisateur(int id, String nom_ar, String nom_fr, String prenom_ar, String prenom_fr, String role, String mot_de_passe, String login, int id_commune, List<RegistreNaiss> registres) {
        this.id = id;
        this.nom_ar = nom_ar;
        this.nom_fr = nom_fr;
        this.prenom_ar = prenom_ar;
        this.prenom_fr = prenom_fr;
        this.role = role;
        this.mot_de_passe = mot_de_passe;
        this.login = login;
        this.id_commune = id_commune;
        this.registres = registres;
    }



    public Utilisateur() {
    }

    public void add(RegistreNaiss registre)
    {
        if(registres==null){
            registres=new ArrayList<>();
        }
        registres.add(registre);
//    /registre.setUtilisateur(this);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom_ar='" + nom_ar + '\'' +
                ", nom_fr='" + nom_fr + '\'' +
                ", prenom_ar='" + prenom_ar + '\'' +
                ", prenom_fr='" + prenom_fr + '\'' +
                ", role='" + role + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", login='" + login + '\'' +
                ", id_commune=" + id_commune +
                ", registres=" + registres +
                '}';
    }
}
