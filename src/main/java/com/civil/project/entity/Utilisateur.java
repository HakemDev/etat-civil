package com.civil.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "utilisateur")
@JsonIgnoreType
@Data
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private int id;

    @Column(name="nom_ar")
    private String nomAr;

    @Column(name="nom_fr")
    private String nomFr;

    @Column(name="prenom_ar")
    private String prenomAr;

    @Column(name="prenom_fr")
    private String prenomFr;

    @Column(name="role")
    private String role;

    @Column(name="mot_de_passe")
    private String motDePasse;

    @Column(name="login")
    private String login;

    @Column(name="id_commune")
    private int idCommune;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,CascadeType.PERSIST,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name="id_utilisateur")
    private List<RegistreNaiss> registres;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,CascadeType.PERSIST,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name="id_utilisateur")
    //@JsonIgnore
    private List<RegistreJugeNaiss> registresjugenaissa;

    

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
