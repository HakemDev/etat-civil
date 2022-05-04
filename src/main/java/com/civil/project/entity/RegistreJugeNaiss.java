package com.civil.project.entity;



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

    @Column(name = "tribunal_ar")
    private String tribunalAr;

    @Column(name = "tribunal_fr")
    private String tribunalFr;

    @Column(name = "region_fr")
    private String regionFr;

    @Column(name = "ville_fr")
    private String villeFr;

    @Column(name = "region_ar")
    private String regionAr;

    @Column(name = "ville_ar")
    private String villeAr;

    @Column(name = "annee")
    private int annee;

    @Column(name="partie")
    private int partie;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.PERSIST,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="id_registre")
    private List<ActeJugeNaissancee> actesjugenaissancee;
}
