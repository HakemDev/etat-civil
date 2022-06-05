package com.civil.project.jugesNaissances.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="registre_juge_naissance")
@Data
public class RegistreJugeNaiss {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_registre")
    private int idRegistre;
  
    @Column(name = "id_utilisateur")
    private int idUtilisateur;

    @Column(name="date_edition")
    private  String edition;

    @Column(name = "tribunal")
    private String tribunal;

    @Column(name = "annee")
    private int annee;

    @Column(name="partie")
    private int partie;

    @Column(name = "dernier_numero")
    private int dernierNumero;


    @Column(name = "nombre_actes")
    private int nombreActes;


    @Column(name = "premier_numero")
    private int premierNumero;

    

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.PERSIST,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="id_registre")
    @JsonIgnore
    private List<ActeJugeNaissancee> actesjugenaissancee;
}
