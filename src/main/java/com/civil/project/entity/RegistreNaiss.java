package com.civil.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "registre")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreType
public class RegistreNaiss {
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

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.PERSIST,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="id_registre")
    private List<ActeNaissance> actes;
    public void add(ActeNaissance acte)
    {
        if(actes==null){
            actes=new ArrayList<>();
        }
        actes.add(acte);
//    /registre.setUtilisateur(this);
    }
}
