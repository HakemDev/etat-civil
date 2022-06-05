package com.civil.project.security.entity;

import com.civil.project.jugesNaissances.entity.RegistreJugeNaiss;
import com.civil.project.naissances.entity.RegistreNaiss;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
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
    // todo remove joincolumn
    @JoinColumn(name="id_utilisateur")
    private List<RegistreNaiss> registres;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,CascadeType.PERSIST,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @Fetch(value = FetchMode.SUBSELECT)
    // todo remove joincolumn
    @JoinColumn(name="id_utilisateur")
    //@JsonIgnore
    private List<RegistreJugeNaiss> registresjugenaissa;

    public Utilisateur(String nomAr, String nomFr, String prenomAr, String prenomFr, String role, String motDePasse, String login, int idCommune, List<RegistreNaiss> registres, List<RegistreJugeNaiss> registresjugenaissa) {
        this.nomAr = nomAr;
        this.nomFr = nomFr;
        this.prenomAr = prenomAr;
        this.prenomFr = prenomFr;
        this.role = role;
        this.motDePasse = motDePasse;
        this.login = login;
        this.idCommune = idCommune;
        this.registres = registres;
        this.registresjugenaissa = registresjugenaissa;
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
                ", nomAr='" + nomAr + '\'' +
                ", nomFr='" + nomFr + '\'' +
                ", prenomAr='" + prenomAr + '\'' +
                ", prenomFr='" + prenomFr + '\'' +
                ", role='" + role + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", login='" + login + '\'' +
                ", idCommune=" + idCommune +
                ", registres=" + registres +
                ", registresjugenaissa=" + registresjugenaissa +
                '}';
    }
}
