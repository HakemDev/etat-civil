package com.civil.project.security.entity;

import com.civil.project.jugesNaissances.entity.RegistreJugeNaiss;
import com.civil.project.naissances.entity.RegistreNaiss;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utilisateur")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String motDePasse;

    @Column(name="login")
    private String login;

}
