package com.civil.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
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
    @JoinColumn(name="id_utilisateur")
    private List<RegistreNaiss> registres;

}
