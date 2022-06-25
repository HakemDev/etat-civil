package com.civil.project.naissances.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "registre")
@AllArgsConstructor
@NoArgsConstructor
public class RegistreNaiss {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_registre")
    private int idRegistre;

    //@Column(name = "id_utilisateur")
    //private int idUtilisateur;

    @Column(name = "tribunal")
    private String tribunal;

    @Column(name = "annee")
    private int annee;


    @Column(name = "premier_numero")
    private int premierNumero;

    @Column(name = "dernier_numero")
    private int dernierNumero;


    @Column(name = "nombre_actes")
    private int nombreActes;
  
    @Column(name = "date_edition")
    private Date dateEdition;

    @Column(name="partie")
    private int partie;

    @OneToMany(
            mappedBy = "registre",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<ActeNaissance> actes;

    @Override
    public String toString() {
        return "RegistreNaiss{" +
                "idRegistre=" + idRegistre +
                ", tribunal='" + tribunal + '\'' +
                ", annee=" + annee +
                ", premierNumero=" + premierNumero +
                ", dernierNumero=" + dernierNumero +
                ", nombreActes=" + nombreActes +
                ", dateEdition=" + dateEdition +
                ", partie=" + partie +
                '}';
    }
}
